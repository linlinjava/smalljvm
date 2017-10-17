package smalljvm.interpreter.math.sum;

public class TestInterpreter {
    public static void main(String[] args) throws java.io.IOException {
        smalljvm.interpreter.JVM jvm = new smalljvm.interpreter.JVM();
        String className = Demo.class.getName();
        className = className.replace('.', '/');
        jvm.run(className);

        smalljvm.rtda.MethodArea area = jvm.methodarea();
        smalljvm.rtda.KClass clazz = area.getClass(className);
        smalljvm.rtda.LocalVariableTable lvt = clazz.getStaticSlots();

        int result = lvt.getInt(0);
        System.out.println("Small JVM result: " + result);

        Demo.main(new String[0]);
        System.out.println("Hotspot JVM result: " + Demo.result);
    }
}
