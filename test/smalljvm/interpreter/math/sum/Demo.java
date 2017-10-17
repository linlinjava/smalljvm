package smalljvm.interpreter.math.sum;

public class Demo {
    public static int result = -1;

    public static void main(String[] args) {
        int sum = 0;
        for(int i = 1; i <= 3; i++){
            sum += i;
        }

        Demo.result = sum;

        return;
    }
}
