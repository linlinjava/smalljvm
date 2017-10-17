package smalljvm.interpreter.constant.iconst;

public class TestInterpreter {
    public static void main(String[] args) throws java.io.IOException {
        smalljvm.interpreter.JVM jvm = new smalljvm.interpreter.JVM();
        String className = Demo.class.getName();
        className = className.replace('.', '/');
        jvm.run(className);

        smalljvm.rtda.MethodArea area = jvm.methodarea();
        smalljvm.rtda.KClass clazz = area.getClass(className);
        smalljvm.rtda.LocalVariableTable lvt = clazz.getStaticSlots();

        // int int int int int int int
        //  0   1   2   3   4   5   6
        int result_iconst_ml = lvt.getInt(0);
        int result_iconst_0 = lvt.getInt(1);
        int result_iconst_1 = lvt.getInt(2);
        int result_iconst_2 = lvt.getInt(3);
        int result_iconst_3 = lvt.getInt(4);
        int result_iconst_4 = lvt.getInt(5);
        int result_iconst_5 = lvt.getInt(6);


        System.out.println("Small JVM  result_iconst_ml: " + result_iconst_ml);
        System.out.println("Small JVM  result_iconst_0: " + result_iconst_0);
        System.out.println("Small JVM  result_iconst_1: " + result_iconst_1);
        System.out.println("Small JVM  result_iconst_2: " + result_iconst_2);
        System.out.println("Small JVM  result_iconst_3: " + result_iconst_3);
        System.out.println("Small JVM  result_iconst_4: " + result_iconst_4);
        System.out.println("Small JVM  result_iconst_5: " + result_iconst_5);

        Demo.main(new String[0]);
        System.out.println("Hotspot JVM  result_iconst_ml: " + Demo.result_iconst_ml);
        System.out.println("Hotspot JVM  result_iconst_0: " + Demo.result_iconst_0);
        System.out.println("Hotspot JVM  result_iconst_1: " + Demo.result_iconst_1);
        System.out.println("Hotspot JVM  result_iconst_2: " + Demo.result_iconst_2);
        System.out.println("Hotspot JVM  result_iconst_3: " + Demo.result_iconst_3);
        System.out.println("Hotspot JVM  result_iconst_4: " + Demo.result_iconst_4);
        System.out.println("Hotspot JVM  result_iconst_5: " + Demo.result_iconst_5);

    }
}
