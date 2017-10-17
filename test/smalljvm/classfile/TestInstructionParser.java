package smalljvm.classfile;

import smalljvm.classfile.attribute.CodeAttribute;
import smalljvm.rtda.KClass;

import java.io.DataInput;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestInstructionParser {
    public static void main(String[] args) {
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

        MethodInfo mainMethod = c.findMethod("main", null);
        System.out.println(mainMethod.toString());

        System.out.println("Instruction Codes");
        System.out.println("Index PC Instruction");
        CodeAttribute codeAttribute = mainMethod.codeAttribute();
        Instruction[] instructions = InstructionParser.parse(codeAttribute.code);
        int index = 0;
        int pc = 0;
        for(Instruction instruction : instructions){
            System.out.println(index + " " + pc + " " + instruction.toString());
            index++;
            pc += instruction.length();
        }
    }
}
