package smalljvm.classfile;


import smalljvm.classfile.attribute.CodeAttribute;

import java.io.*;

public class TestClassFileParser {
    static void test1(){
        ClassFile c = null;

        try {
            ClassFileReader reader = new ClassFileReader();
            DataInput input = reader.read("out/test/smalljvm/", "smalljvm/classfile/Hello");

            ClassFileParser parser = new ClassFileParser();
            c = parser.parse(input);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(c.toString());
        MethodInfo mainMethod = c.findMethod("main", null);
        System.out.println(mainMethod.toString());
    }

    static void test2(){
        ClassFile c = null;

        try {
            ClassFileReader reader = new ClassFileReader();
            DataInput input = reader.read(System.getenv("JAVA_HOME")+"/jre/lib/rt.jar", "java/lang/Object");

            ClassFileParser parser = new ClassFileParser();
            c = parser.parse(input);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(c.toString());
    }
    public static void main(String[] args) {
        test1();
        test2();
    }
}
