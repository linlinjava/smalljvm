package smalljvm.classfile.class1;


import smalljvm.classfile.ClassFile;
import smalljvm.classfile.ClassFileParser;
import smalljvm.classfile.ClassFileReader;

import java.io.DataInput;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestClassFileParser {
    public static void main(String[] args) {
        ClassFile c = null;

        try {
            ClassFileReader reader = new ClassFileReader();
            DataInput input = reader.read("out/test/smalljvm/", "smalljvm/classfile/class1/Subclass");

            ClassFileParser parser = new ClassFileParser();
            c = parser.parse(input);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(c.toString());
    }
}
