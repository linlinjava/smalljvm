package smalljvm.interpreter.math.neg;

public class Demo {
    public static int result_int = 1;
    public static long result_long = 2L;
    public static float result_float = 3.0F;
    public static double result_double = 4.0;

    public static void main(String[] args) {
        result_int = -result_int;
        result_long = -result_long;
        result_float = -result_float;
        result_double = -result_double;
        return;
    }
}
