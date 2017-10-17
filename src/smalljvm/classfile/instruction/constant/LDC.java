package smalljvm.classfile.instruction.constant;

import smalljvm.classfile.Instruction;

/**
 * Created by junling on 2017/3/31.
 */
public class LDC implements Instruction {
    public byte op;
    public byte index;

    @Override
    public byte opcode(){
        return 0x12;
    }

    @Override
    public String strcode (){
        return "ldc";
    }

    @Override
    public String toString() {
        return strcode() + " " + String.valueOf(index);
    }

    @Override
    public int length() {
        return 2;
    }

    public byte index() {
        return index;
    }
}
