package smalljvm.classfile.instruction.math;

import smalljvm.classfile.Instruction;

/**
 * Created by junling on 2017/3/31.
 */
public class FMUL implements Instruction {

    public byte op;

    @Override
    public byte opcode(){
        return 0x6a;
    }

    @Override
    public String strcode (){
        return "fmul";
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
