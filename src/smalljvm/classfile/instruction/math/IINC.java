package smalljvm.classfile.instruction.math;

import smalljvm.classfile.Instruction;

/**
 * Created by junling on 2017/3/31.
 */
public class IINC implements Instruction {
    public byte op;
    public byte index;
    public byte constant;

    @Override
    public byte opcode(){
        return (byte)0x84;
    }

    @Override
    public String strcode (){
        return "iinc";
    }

    @Override
    public String toString() {
        return strcode() + " " + index + " " + constant;
    }

    @Override
    public int length() {
        return 3;
    }
}
