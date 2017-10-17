package smalljvm.interpreter.conversion.i2;

public class Demo {
    public static byte result_byte = 1;
    public static char result_char = 1;
    public static short result_short = 1;
    public static long result_long = 1L;
    public static float result_float = 1.0F;
    public static double result_double = 1.0;

    public static void main(String[] args) {
        int byte_max = Byte.MAX_VALUE;
        result_byte = (byte)(byte_max + 1);
        int char_max = Character.MAX_VALUE;
        result_char = (char)(char_max + 1);
        int short_max = Short.MAX_VALUE;
        result_short = (short)(short_max + 1);
        long long_max = Long.MAX_VALUE;
        result_long = (long)(long_max + 1);
        float float_max = Float.MAX_VALUE;
        result_float = (float)(float_max + 1);
        double double_max = Double.MAX_VALUE;
        result_double = (double)(double_max + 1);
        return;
    }
}
