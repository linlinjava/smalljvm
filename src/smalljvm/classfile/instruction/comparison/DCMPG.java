package smalljvm.classfile.instruction.comparison;

import smalljvm.classfile.Instruction;

/**
 * Created by junling on 2017/3/31.
 */
public class DCMPG implements Instruction {

    public byte op;

    @Override
    public byte opcode(){
        return (byte)0x98;
    }

    @Override
    public String strcode (){
        return "dcmpg";
    }

    @Override
    public int length() {
        return 1;
    }

    @Override
    public String toString() {
        return strcode();
    }
}
