package smalljvm.interpreter.clinit.clinit3;

public class Demo {
    public static byte result_byte = 1;
    public static char result_char = 1;
    public static short result_short = 1;
    public static long result_long = 1L;
    public static float result_float = 1.0F;
    public static double result_double = 1.0;

    static {
        result_byte = 2;
        result_char = 2;
        result_short = 2;
        result_long = 2L;
        result_float = 2.0F;
        result_double = 2.0;
    }
    public static void main(String[] args) {
        byte result = Demo.result_byte;
        return;
    }
}
