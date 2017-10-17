package smalljvm.interpreter.reference.newarray1;

public class Demo {
    public int m_int = 1;

    public Demo(int v1, float v2, double v3){
        int[] aa = new int[3];

        m_int = aa[0];
    }

    public static Demo result = null;

    public static void main(String[] args) {
        Demo.result = new Demo(2, 2.0F, 2);
        return;
    }
}
