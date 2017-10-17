package smalljvm.interpreter.constant.fconst;

public class TestInterpreter {
    public static void main(String[] args) throws java.io.IOException {
        smalljvm.interpreter.JVM jvm = new smalljvm.interpreter.JVM();
        String className = Demo.class.getName();
        className = className.replace('.', '/');
        jvm.run(className);

        smalljvm.rtda.MethodArea area = jvm.methodarea();
        smalljvm.rtda.KClass clazz = area.getClass(className);
        smalljvm.rtda.LocalVariableTable lvt = clazz.getStaticSlots();

        // float   float    float
        //  0       1       2
        float result_fconst_0 = lvt.getFloat(0);
        float result_fconst_1 = lvt.getFloat(1);
        float result_fconst_2 = lvt.getFloat(2);


        System.out.println("Small JVM  result_fconst_0: " + result_fconst_0);
        System.out.println("Small JVM  result_fconst_1: " + result_fconst_1);
        System.out.println("Small JVM  result_fconst_2: " + result_fconst_2);

        smalljvm.interpreter.constant.fconst.Demo.main(new String[0]);
        System.out.println("Hotspot JVM  result_fconst_0: " + smalljvm.interpreter.constant.fconst.Demo.result_fconst_0);
        System.out.println("Hotspot JVM  result_fconst_1: " + smalljvm.interpreter.constant.fconst.Demo.result_fconst_1);
        System.out.println("Hotspot JVM  result_fconst_2: " + smalljvm.interpreter.constant.fconst.Demo.result_fconst_2);
    }
}
