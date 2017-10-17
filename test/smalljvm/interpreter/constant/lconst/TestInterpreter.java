package smalljvm.interpreter.constant.lconst;

public class TestInterpreter {
    public static void main(String[] args) throws java.io.IOException {
        smalljvm.interpreter.JVM jvm = new smalljvm.interpreter.JVM();
        String className = Demo.class.getName();
        className = className.replace('.', '/');
        jvm.run(className);

        smalljvm.rtda.MethodArea area = jvm.methodarea();
        smalljvm.rtda.KClass clazz = area.getClass(className);
        smalljvm.rtda.LocalVariableTable lvt = clazz.getStaticSlots();

        // long   long
        // 0&1    2&3
        long result_lconst_0 = lvt.getLong(0);
        long result_lconst_1 = lvt.getLong(2);


        System.out.println("Small JVM  result_lconst_0: " + result_lconst_0);
        System.out.println("Small JVM  result_lconst_1: " + result_lconst_1);

        smalljvm.interpreter.constant.lconst.Demo.main(new String[0]);
        System.out.println("Hotspot JVM  result_lconst_0: " + smalljvm.interpreter.constant.lconst.Demo.result_lconst_0);
        System.out.println("Hotspot JVM  result_lconst_1: " + smalljvm.interpreter.constant.lconst.Demo.result_lconst_1);
    }
}
