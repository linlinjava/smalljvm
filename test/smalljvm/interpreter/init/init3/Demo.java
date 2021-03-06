package smalljvm.interpreter.init.init3;

public class Demo extends SuperDemo {
    public int m_int = 1;
    public float m_float = 1.0F;
    public double m_double = 1.0;

    public Demo(int v1, float v2, double v3){
        super(v1+1, v2+1, v3+1);
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