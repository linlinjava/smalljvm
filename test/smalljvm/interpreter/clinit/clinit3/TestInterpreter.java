package smalljvm.interpreter.clinit.clinit3;

public class TestInterpreter {
    public static void main(String[] args) throws java.io.IOException {
        smalljvm.interpreter.JVM jvm = new smalljvm.interpreter.JVM();
        String className = Demo.class.getName();
        className = className.replace('.', '/');
        jvm.run(className);

        smalljvm.rtda.MethodArea area = jvm.methodarea();
        smalljvm.rtda.KClass clazz = area.getClass(className);
        smalljvm.rtda.LocalVariableTable lvt = clazz.getStaticSlots();

        // byte  char    short   long   float   double
        //  0   1        2       3&4    5       6&7
        byte result_byte = (byte)lvt.getInt(0);
        char result_char = (char)lvt.getInt(1);
        short result_short = (short)lvt.getInt(2);
        long result_long = lvt.getLong(3);
        float result_float = lvt.getFloat(5);
        double result_double = lvt.getDouble(6);

        System.out.println("Small JVM result_byte: " + result_byte);
        System.out.println("Small JVM result_char: " + result_char);
        System.out.println("Small JVM result_short: " + result_short);
        System.out.println("Small JVM result_long: " + result_long);
        System.out.println("Small JVM result_float: " + result_float);
        System.out.println("Small JVM result_double: " + result_double);

        Demo.main(new String[0]);
        System.out.println("Hotspot JVM result_byte: " + Demo.result_byte);
        System.out.println("Hotspot JVM result_char: " + Demo.result_char);
        System.out.println("Hotspot JVM result_short: " + Demo.result_short);
        System.out.println("Hotspot JVM result_long: " + Demo.result_long);
        System.out.println("Hotspot JVM result_float: " + Demo.result_float);
        System.out.println("Hotspot JVM result_double: " + Demo.result_double);
    }
}
