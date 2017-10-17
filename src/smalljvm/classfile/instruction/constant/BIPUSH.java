package smalljvm.classfile.instruction.constant;

import smalljvm.classfile.Instruction;

/**
 * Created by junling on 2017/3/31.
 */
public class BIPUSH implements Instruction {
    public byte op;
    public byte value;

    @Override
    public byte opcode(){
        return 0x10;
    }

    @Override
    public String strcode (){
        return "bipush";
    }

    @Override
    public String toString() {
        return strcode() + " " + String.valueOf(value);
    }

    public byte value() {
        return value;
    }

    @Override
    public int length() {
        return 2;
    }
}
