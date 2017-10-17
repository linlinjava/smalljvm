package smalljvm.interpreter.math.shift;

public class Demo {
    public static int result_ishl = 32;
    public static int result_ishr = 32;
    public static int result_iushr = 32;

    public static long result_lshl = 32L;
    public static long result_lshr = 32L;
    public static long result_lushr = 32L;


    public static void main(String[] args) {
        result_ishl >>= 4;
        result_ishr <<= 4;
        result_iushr >>>= 4;

        result_lshl >>= 4;
        result_lshr <<= 4;
        result_lushr >>>= 4;
        return;
    }
}
