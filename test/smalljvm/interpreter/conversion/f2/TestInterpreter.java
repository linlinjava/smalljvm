package smalljvm.interpreter.conversion.f2;

import java.io.IOException;

public class TestInterpreter {
    public static void main(String[] args) throws IOException {
        smalljvm.interpreter.JVM jvm = new smalljvm.interpreter.JVM();
        String className = Demo.class.getName();
        className = className.replace('.', '/');
        jvm.run(className);

        smalljvm.rtda.MethodArea area = jvm.methodarea();
        smalljvm.rtda.KClass clazz = area.getClass(className);
        smalljvm.rtda.LocalVariableTable lvt = clazz.getStaticSlots();
        // int  long   double   int     long    double
        //  0   1&2     3&4     5       6&7     8&9
        int result_int1 = lvt.getInt(0);
        long result_long1 = lvt.getLong(1);
        double result_double1 = lvt.getDouble(3);
        int result_int2 = lvt.getInt(5);
        long result_long2 = lvt.getLong(6);
        double result_double2 = lvt.getDouble(8);

        System.out.println("Small JVM result_int1: " + result_int1);
        System.out.println("Small JVM result_long1: " + result_long1);
        System.out.println("Small JVM result_double1: " + result_double1);
        System.out.println("Small JVM result_int2: " + result_int2);
        System.out.println("Small JVM result_long2: " + result_long2);
        System.out.println("Small JVM result_double2: " + result_double2);

        Demo.main(new String[0]);
        System.out.println("Hotspot JVM result_int1: " + Demo.result_int1);
        System.out.println("Hotspot JVM result_long1: " + Demo.result_long1);
        System.out.println("Hotspot JVM result_double1: " + Demo.result_double1);
        System.out.println("Hotspot JVM result_int2: " + Demo.result_int2);
        System.out.println("Hotspot JVM result_long2: " + Demo.result_long2);
        System.out.println("Hotspot JVM result_double2: " + Demo.result_double2);
    }
}
