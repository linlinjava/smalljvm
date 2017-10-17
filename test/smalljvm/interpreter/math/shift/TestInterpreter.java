package smalljvm.interpreter.math.shift;

public class TestInterpreter {
    public static void main(String[] args) throws java.io.IOException {
        smalljvm.interpreter.JVM jvm = new smalljvm.interpreter.JVM();
        String className = Demo.class.getName();
        className = className.replace('.', '/');
        jvm.run(className);

        smalljvm.rtda.MethodArea area = jvm.methodarea();
        smalljvm.rtda.KClass clazz = area.getClass(className);
        smalljvm.rtda.LocalVariableTable lvt = clazz.getStaticSlots();

        // int    int    int    long    long    long
        // 0      1      2      3&4     5&6     7&8
        int result_ishl = lvt.getInt(0);
        int result_ishr = lvt.getInt(1);
        int result_iushr = lvt.getInt(2);
        long result_lshl = lvt.getLong(3);
        long result_lshr = lvt.getLong(5);
        long result_lushr = lvt.getLong(7);
        System.out.println("Small JVM result_ishl: " + result_ishl);
        System.out.println("Small JVM result_ishr: " + result_ishr);
        System.out.println("Small JVM result_iushr: " + result_iushr);
        System.out.println("Small JVM result_lshl: " + result_lshl);
        System.out.println("Small JVM result_lshr: " + result_lshr);
        System.out.println("Small JVM result_lushr: " + result_lushr);

        Demo.main(new String[0]);
        System.out.println("Hotspot JVM result_ishl: " + Demo.result_ishl);
        System.out.println("Hotspot JVM result_ishr: " + Demo.result_ishr);
        System.out.println("Hotspot JVM result_iushr: " + Demo.result_iushr);
        System.out.println("Hotspot JVM result_lshl: " + Demo.result_lshl);
        System.out.println("Hotspot JVM result_lshr: " + Demo.result_lshr);
        System.out.println("Hotspot JVM result_lushr: " + Demo.result_lushr);
    }
}
