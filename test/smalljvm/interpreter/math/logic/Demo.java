package smalljvm.interpreter.math.logic;

public class Demo {
    public static int result_iand = 1;
    public static long result_land = 1L;
    public static int result_ior = 1;
    public static long result_lor = 1L;
    public static int result_ixor = 1;
    public static long result_lxor = 1L;

    public static void main(String[] args) {
        result_iand &= 32;
        result_land &= 32;
        result_ior |= 32;
        result_lor |= 32;
        result_ixor ^= 32;
        result_lxor ^= 32;
        return;
    }
}
