package smalljvm.classfile.instruction.math;

import smalljvm.classfile.Instruction;

/**
 * Created by junling on 2017/3/31.
 */
public class LXOR implements Instruction {

    public byte op;

    @Override
    public byte opcode(){
        return (byte)0x83;
    }

    @Override
    public String strcode (){
        return "lxor";
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
