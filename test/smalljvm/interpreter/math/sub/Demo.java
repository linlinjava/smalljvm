package smalljvm.interpreter.math.sub;

public class Demo {
    public static int result_int = 1;
    public static long result_long = 2L;
    public static float result_float = 3.0F;
    public static double result_double = 4.0;

    public static void main(String[] args) {
        result_int -= 100;
        result_long -= 1111111111111L;
        result_float -= 0.1F;
        result_double -= 0.0000000000001;
        return;
    }
}
