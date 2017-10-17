package smalljvm.interpreter.constant.push;

import smalljvm.interpreter.JVM;
import smalljvm.rtda.KClass;
import smalljvm.rtda.LocalVariableTable;
import smalljvm.rtda.MethodArea;

import java.io.IOException;

public class TestInterpreter {
    public static void main(String[] args) throws IOException {
        JVM jvm = new JVM();
        String className = Demo.class.getName();
        className = className.replace('.', '/');
        jvm.run(className);

        MethodArea area = jvm.methodarea();
        KClass clazz = area.getClass(className);
        LocalVariableTable lvt = clazz.getStaticSlots();

        // int int
        //  0   1
        int result_bipush = lvt.getInt(0);
        int result_sipush = lvt.getInt(1);


        System.out.println("Small JVM  result_bipush: " + result_bipush);
        System.out.println("Small JVM  result_sipush: " + result_sipush);

        Demo.main(new String[0]);
        System.out.println("Hotspot JVM  result_bipush: " + Demo.result_bipush);
        System.out.println("Hotspot JVM  result_sipush: " + Demo.result_sipush);
    }
}
