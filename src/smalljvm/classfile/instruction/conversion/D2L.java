package smalljvm.classfile.instruction.conversion;

import smalljvm.classfile.Instruction;

/**
 * Created by junling on 2017/3/31.
 */
public class D2L implements Instruction {

    public byte op;

    @Override
    public byte opcode(){
        return (byte)0x8f;
    }

    @Override
    public String strcode (){
        return "d2l";
    }

    @Override
    public String toString() {
        return strcode();
    }

    @Override
    public int length() {
        return 1;
    }
}
