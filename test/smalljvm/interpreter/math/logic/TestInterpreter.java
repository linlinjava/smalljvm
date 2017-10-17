package smalljvm.interpreter.math.logic;

public class TestInterpreter {
    public static void main(String[] args) throws java.io.IOException {
        smalljvm.interpreter.JVM jvm = new smalljvm.interpreter.JVM();
        String className = Demo.class.getName();
        className = className.replace('.', '/');
        jvm.run(className);

        smalljvm.rtda.MethodArea area = jvm.methodarea();
        smalljvm.rtda.KClass clazz = area.getClass(className);
        smalljvm.rtda.LocalVariableTable lvt = clazz.getStaticSlots();
        // int  long    int     long    int     long
        //  0   1&2     3       4&5     6       7&8
        int result_iand = lvt.getInt(0);
        long result_land = lvt.getLong(1);
        int result_ior = lvt.getInt(3);
        long result_lor = lvt.getLong(4);
        int result_ixor = lvt.getInt(6);
        long result_lxor = lvt.getLong(7);

        System.out.println("Small JVM result_iand: " + result_iand);
        System.out.println("Small JVM result_land: " + result_land);
        System.out.println("Small JVM result_ior: " + result_ior);
        System.out.println("Small JVM result_lor: " + result_lor);
        System.out.println("Small JVM result_ixor: " + result_ixor);
        System.out.println("Small JVM result_lxor: " + result_lxor);

        Demo.main(new String[0]);
        System.out.println("Hotspot JVM result_iand: " + Demo.result_iand);
        System.out.println("Hotspot JVM result_land: " + Demo.result_land);
        System.out.println("Hotspot JVM result_ior: " + Demo.result_ior);
        System.out.println("Hotspot JVM result_lor: " + Demo.result_lor);
        System.out.println("Hotspot JVM result_ixor: " + Demo.result_ixor);
        System.out.println("Hotspot JVM result_lxor: " + Demo.result_lxor);
    }
}
