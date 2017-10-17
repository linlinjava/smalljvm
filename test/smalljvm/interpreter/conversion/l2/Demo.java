package smalljvm.interpreter.conversion.l2;

public class Demo {
    public static int result_int = 1;
    public static float result_float = 1.0F;
    public static double result_double = 1.0;

    public static void main(String[] args) {
        long value = 11111111111111L;
        result_int = (int)value;
        result_float = (float)value;
        result_double = (double)value;
        return;
    }
}
