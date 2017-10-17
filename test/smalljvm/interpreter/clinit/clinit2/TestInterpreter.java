package smalljvm.interpreter.clinit.clinit2;

public class TestInterpreter {
    public static void main(String[] args) throws java.io.IOException {
        smalljvm.interpreter.JVM jvm = new smalljvm.interpreter.JVM();
        String className = Subclass.class.getName();
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
        System.out.println("Small JVM Subclass.result_byte: " + result_byte);
        System.out.println("Small JVM Subclass.result_char: " + result_char);
        System.out.println("Small JVM Subclass.result_short: " + result_short);
        System.out.println("Small JVM Subclass.result_long: " + result_long);
        System.out.println("Small JVM Subclass.result_float: " + result_float);
        System.out.println("Small JVM Subclass.result_double: " + result_double);

        String supclassName = "smalljvm/interpreter/clinit/clinit2/Superclass";
        clazz = area.getClass(supclassName);
        lvt = clazz.getStaticSlots();
        // byte  char    short   long   float   double
        //  0   1        2       3&4    5       6&7
        result_byte = (byte)lvt.getInt(0);
        result_char = (char)lvt.getInt(1);
        result_short = (short)lvt.getInt(2);
        result_long = lvt.getLong(3);
        result_float = lvt.getFloat(5);
        result_double = lvt.getDouble(6);
        System.out.println("Small JVM Superclass.result_byte: " + result_byte);
        System.out.println("Small JVM Superclass.result_char: " + result_char);
        System.out.println("Small JVM Superclass.result_short: " + result_short);
        System.out.println("Small JVM Superclass.result_long: " + result_long);
        System.out.println("Small JVM Superclass.result_float: " + result_float);
        System.out.println("Small JVM Superclass.result_double: " + result_double);

        Subclass.main(new String[0]);
        System.out.println("Hotspot JVM Subclass.result_byte: " + Subclass.result_byte);
        System.out.println("Hotspot JVM Subclass.result_char: " + Subclass.result_char);
        System.out.println("Hotspot JVM Subclass.result_short: " + Subclass.result_short);
        System.out.println("Hotspot JVM Subclass.result_long: " + Subclass.result_long);
        System.out.println("Hotspot JVM Subclass.result_float: " + Subclass.result_float);
        System.out.println("Hotspot JVM Subclass.result_double: " + Subclass.result_double);
        System.out.println("Hotspot JVM Superclass.result_byte: " + Superclass.result_byte);
        System.out.println("Hotspot JVM Superclass.result_char: " + Superclass.result_char);
        System.out.println("Hotspot JVM Superclass.result_short: " + Superclass.result_short);
        System.out.println("Hotspot JVM Superclass.result_long: " + Superclass.result_long);
        System.out.println("Hotspot JVM Superclass.result_float: " + Superclass.result_float);
        System.out.println("Hotspot JVM Superclass.result_double: " + Superclass.result_double);
    }
}
