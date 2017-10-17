package smalljvm.interpreter.reference.invokevirtual2;

public class SuperDemo {
    public int m_int = 1;
    public float m_float = 1.0F;
    public double m_double = 1.0;

    protected void performInit(int v1, float v2, double v3){
        m_int = v1;
        m_float = v2;
        m_double = v3;
    }
}
