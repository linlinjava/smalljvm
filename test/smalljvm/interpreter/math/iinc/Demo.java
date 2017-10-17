package smalljvm.interpreter.math.iinc;

public class Demo {
    public static int result_int1 = 1;
    public static int result_int2 = 1;
    public static int result_int3 = 1;

    public static void main(String[] args) {
        for(int i = 0; i < 3; i++)
            result_int1 += i;
        for(int i = 3; i >=0; i--)
            result_int2 += i;
        for(int i = 0; i < 3; i+=2)
            result_int3 += i;
        return;
    }
}
