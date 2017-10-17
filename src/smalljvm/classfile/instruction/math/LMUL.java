package smalljvm.classfile.instruction.math;

import smalljvm.classfile.Instruction;

/**
 * Created by junling on 2017/3/31.
 */
public class LMUL implements Instruction {

    public byte op;

    @Override
    public byte opcode(){
        return 0x69;
    }

    @Override
    public String strcode (){
        return "lmul";
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
