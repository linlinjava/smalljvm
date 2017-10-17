package smalljvm.classfile.instruction.math;

import smalljvm.classfile.Instruction;

/**
 * Created by junling on 2017/3/31.
 */
public class DSUB implements Instruction {

    public byte op;

    @Override
    public byte opcode(){
        return 0x67;
    }

    @Override
    public String strcode (){
        return "dsub";
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
