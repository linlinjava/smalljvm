package smalljvm.interpreter.math.iinc;

public class TestInterpreter {
    public static void main(String[] args) throws java.io.IOException {
        smalljvm.interpreter.JVM jvm = new smalljvm.interpreter.JVM();
        String className = Demo.class.getName();
        className = className.replace('.', '/');
        jvm.run(className);

        smalljvm.rtda.MethodArea area = jvm.methodarea();
        smalljvm.rtda.KClass clazz = area.getClass(className);
        smalljvm.rtda.LocalVariableTable lvt = clazz.getStaticSlots();
        // int  int     int
        //  0   1       2
        int result_int1 = lvt.getInt(0);
        int result_int2 = lvt.getInt(1);
        int result_int3 = lvt.getInt(2);

        System.out.println("Small JVM result_int1: " + result_int1);
        System.out.println("Small JVM result_int2: " + result_int2);
        System.out.println("Small JVM result_int3: " + result_int3);

        Demo.main(new String[0]);
        System.out.println("Hotspot JVM result_int1: " + Demo.result_int1);
        System.out.println("Hotspot JVM result_int2: " + Demo.result_int2);
        System.out.println("Hotspot JVM result_int3: " + Demo.result_int3);
    }
}
