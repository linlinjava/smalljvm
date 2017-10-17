package smalljvm.classfile.instruction.math;

import smalljvm.classfile.Instruction;

/**
 * Created by junling on 2017/3/31.
 */
public class LSHR implements Instruction {

    public byte op;

    @Override
    public byte opcode(){
        return 0x7b;
    }

    @Override
    public String strcode (){
        return "lshr";
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
