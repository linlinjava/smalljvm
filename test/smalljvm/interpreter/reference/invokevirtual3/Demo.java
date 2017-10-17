package smalljvm.interpreter.reference.invokevirtual3;

public class Demo extends SuperDemo {

    // here we use performInit method, it will generate invokevirtual instruction
    // if we use super.performInit method, it will generate invokespecial instruction
    public Demo(int v1, float v2, double v3) {
        performInit(v1, v2, v3);
    }

    protected void performInit(int v1, float v2, double v3){
        m_int = v1 + 100;
        m_float = v2 + 100;
        m_double = v3 + 100;
    }

    public static Demo result = null;

    public static void main(String[] args) {
        Demo.result = new Demo(2, 2.0F, 2);
        return;
    }
}
