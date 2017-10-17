package smalljvm.interpreter.reference.invokespecial2;

public class Demo {
    public int m_int = 1;
    public float m_float = 1.0F;
    public double m_double = 1.0;

    public Demo(int v1, float v2, double v3) {
        performInit(v1, v2, v3);
    }

    private void performInit(int v1, float v2, double v3){
        m_int = v1;
        m_float = v2;
        m_double = v3;
    }

    public static Demo result = null;

    public static void main(String[] args) {
        Demo.result = new Demo(2, 2.0F, 2);
        return;
    }
}
