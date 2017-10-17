package smalljvm.interpreter.conversion.f2;

public class Demo {
    public static int result_int1 = 1;
    public static long result_long1 = 1L;
    public static double result_double1 = 1.0;
    public static int result_int2 = 1;
    public static long result_long2 = 1L;
    public static double result_double2 = 1.0;

    public static void main(String[] args) {
        float value = 11111.1111F;
        result_int1 = (int)value;
        result_long1 = (long)value;
        result_double1 = (double)value;

        value = 111111111.1111F;
        result_int2 = (int)value;
        result_long2 = (long)value;
        result_double2 = (double)value;

        return;
    }
}
