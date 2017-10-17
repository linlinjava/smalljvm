package smalljvm.rtda;

public class TestKMethodArgs {
    public static void main(String[] args) {
        KMethod method = new KMethod();

        method.descriptor = "()V";
        System.out.println(method.getArgSlotsCount()==0);
        System.out.println(method.getArgCount()==0);

        method.descriptor = "(B)V";
        System.out.println(method.getArgSlotsCount()==1);
        System.out.println(method.getArgCount()==1);

        method.descriptor = "(C)V";
        System.out.println(method.getArgSlotsCount()==1);
        System.out.println(method.getArgCount()==1);

        method.descriptor = "(D)V";
        System.out.println(method.getArgSlotsCount()==2);
        System.out.println(method.getArgCount()==1);

        method.descriptor = "(F)V";
        System.out.println(method.getArgSlotsCount()==1);
        System.out.println(method.getArgCount()==1);

        method.descriptor = "(J)V";
        System.out.println(method.getArgSlotsCount()==2);
        System.out.println(method.getArgCount()==1);

        method.descriptor = "(S)V";
        System.out.println(method.getArgSlotsCount()==1);
        System.out.println(method.getArgCount()==1);

        method.descriptor = "(Z)V";
        System.out.println(method.getArgSlotsCount()==1);
        System.out.println(method.getArgCount()==1);

        method.descriptor = "(Ljava/lang/Object;)V";
        System.out.println(method.getArgSlotsCount()==1);
        System.out.println(method.getArgCount()==1);

        method.descriptor = "([B)V";
        System.out.println(method.getArgSlotsCount()==1);
        System.out.println(method.getArgCount()==1);

        method.descriptor = "([Ljava/lang/Object;)V";
        System.out.println(method.getArgSlotsCount()==1);
        System.out.println(method.getArgCount()==1);

        method.descriptor = "([[[Ljava/lang/Object;)V";
        System.out.println(method.getArgSlotsCount()==1);
        System.out.println(method.getArgCount()==1);

        method.descriptor = "(BCD)V";
        System.out.println(method.getArgSlotsCount()==4);
        System.out.println(method.getArgCount()==3);

        method.descriptor = "(BCD[[Ljava/lang/Object;Ljava/lang/Object;)V";
        System.out.println(method.getArgSlotsCount()==6);
        System.out.println(method.getArgCount()==5);

    }
}
