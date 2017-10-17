package smalljvm.interpreter.reference.invokevirtual2;

public class TestInterpreter {
    public static void main(String[] args) throws java.io.IOException {
        smalljvm.interpreter.JVM jvm = new smalljvm.interpreter.JVM();
        String className = Demo.class.getName();
        className = className.replace('.', '/');
        jvm.run(className);

        smalljvm.rtda.MethodArea area = jvm.methodarea();
        smalljvm.rtda.KClass clazz = area.getClass(className);
        smalljvm.rtda.LocalVariableTable clazz_lvt = clazz.getStaticSlots();
        int objectid = clazz_lvt.getRef(0);
        smalljvm.rtda.Heap heap = jvm.heap();
        smalljvm.rtda.KObject object = heap.findObject(objectid);
        smalljvm.rtda.LocalVariableTable object_lvt = object.slots();
        // int  float   double
        //  0   1       2&3
        int result_int = object_lvt.getInt(0);
        float result_float = object_lvt.getFloat(1);
        double result_double = object_lvt.getDouble(2);

        System.out.println("Small JVM result_int: " + result_int);
        System.out.println("Small JVM result_float: " + result_float);
        System.out.println("Small JVM result_double: " + result_double);

        Demo.main(new String[0]);
        System.out.println("Hotspot JVM result_int: " + Demo.result.m_int);
        System.out.println("Hotspot JVM result_float: " + Demo.result.m_float);
        System.out.println("Hotspot JVM result_double: " + Demo.result.m_double);
    }
}
