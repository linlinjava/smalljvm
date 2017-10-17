package smalljvm.classfile.instruction.math;

import smalljvm.classfile.Instruction;

/**
 * Created by junling on 2017/3/31.
 */
public class LSUB implements Instruction {

    public byte op;

    @Override
    public byte opcode(){
        return 0x65;
    }

    @Override
    public String strcode (){
        return "lsub";
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
