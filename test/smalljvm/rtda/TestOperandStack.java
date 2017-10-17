package smalljvm.rtda;

public class TestOperandStack {
    public static void main(String[] args) {
        OperandStack os = new OperandStack(100);

        os.pushInt(100);
        os.pushInt(-100);

        os.pushLong(2999999999L);
        os.pushLong(-2999999999L);

        os.pushFloat(3.1415F);

        os.pushDouble(2.999999999);

        System.out.println(os.popDouble());
        System.out.println(os.popFloat());
        System.out.println(os.popLong());
        System.out.println(os.popLong());
        System.out.println(os.popInt());
        System.out.println(os.popInt());

    }
}
