package smalljvm.interpreter.reference.invokespecial3;

public class Demo extends ParentDemo {


    public Demo(int v1, float v2, double v3) {
        super(v1, v2, v3);
    }

    public static Demo result = null;

    public static void main(String[] args) {
        Demo.result = new Demo(2, 2.0F, 2);
        return;
    }
}
