package smalljvm.interpreter.init.init1;

public class Demo {
    public int m_int = 1;
    public float m_float = 1.0F;
    public double m_double = 1.0;

    public static Demo result = null;

    public static void main(String[] args) {
        Demo.result = new Demo();
        return;
    }
}