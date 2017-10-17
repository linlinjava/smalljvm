package smalljvm.interpreter.conversion.d2;

public class Demo {
    public static int result_int = 1;
    public static long result_long = 1L;
    public static float result_float = 1.0F;

    public static void main(String[] args) {
        double value = 111111.11111;
        result_int = (int)value;
        result_long = (long)value;
        result_float = (float)value;
        return;
    }
}
