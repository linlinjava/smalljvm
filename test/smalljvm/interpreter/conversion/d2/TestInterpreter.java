package smalljvm.interpreter.conversion.d2;

public class TestInterpreter {
    public static void main(String[] args) throws java.io.IOException {
        smalljvm.interpreter.JVM jvm = new smalljvm.interpreter.JVM();
        String className = Demo.class.getName();
        className = className.replace('.', '/');
        jvm.run(className);

        smalljvm.rtda.MethodArea area = jvm.methodarea();
        smalljvm.rtda.KClass clazz = area.getClass(className);
        smalljvm.rtda.LocalVariableTable lvt = clazz.getStaticSlots();
        // int  long   float
        //  0   1&2     3
        int result_int = lvt.getInt(0);
        long result_long = lvt.getLong(1);
        float result_float = lvt.getFloat(3);

        System.out.println("Small JVM result_int: " + result_int);
        System.out.println("Small JVM result_long: " + result_long);
        System.out.println("Small JVM result_float: " + result_float);

        Demo.main(new String[0]);
        System.out.println("Hotspot JVM result_int: " + Demo.result_int);
        System.out.println("Hotspot JVM result_long: " + Demo.result_long);
        System.out.println("Hotspot JVM result_float: " + Demo.result_float);
    }
}
