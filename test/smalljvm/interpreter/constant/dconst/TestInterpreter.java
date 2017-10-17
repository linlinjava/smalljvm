package smalljvm.interpreter.constant.dconst;

public class TestInterpreter {
    public static void main(String[] args) throws java.io.IOException {
        smalljvm.interpreter.JVM jvm = new smalljvm.interpreter.JVM();
        String className = Demo.class.getName();
        className = className.replace('.', '/');
        jvm.run(className);

        smalljvm.rtda.MethodArea area = jvm.methodarea();
        smalljvm.rtda.KClass clazz = area.getClass(className);
        smalljvm.rtda.LocalVariableTable lvt = clazz.getStaticSlots();

        // double   double
        //  0&1     2&3
        double result_dconst_0 = lvt.getDouble(0);
        double result_dconst_1 = lvt.getDouble(2);


        System.out.println("Small JVM  result_dconst_0: " + result_dconst_0);
        System.out.println("Small JVM  result_dconst_1: " + result_dconst_1);

        Demo.main(new String[0]);
        System.out.println("Hotspot JVM  result_dconst_0: " + Demo.result_dconst_0);
        System.out.println("Hotspot JVM  result_dconst_1: " + Demo.result_dconst_1);

    }
}
