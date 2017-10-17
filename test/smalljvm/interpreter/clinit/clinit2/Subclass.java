package smalljvm.interpreter.clinit.clinit2;

public class Subclass extends Superclass {
    public static byte result_byte = 1;
    public static char result_char = 1;
    public static short result_short = 1;
    public static long result_long = 1L;
    public static float result_float = 1.0F;
    public static double result_double = 1.0;

    public static void main(String[] args) {
        byte result = Subclass.result_byte;
        return;
    }
}
