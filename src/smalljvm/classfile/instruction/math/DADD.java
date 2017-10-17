package smalljvm.classfile.instruction.math;

import smalljvm.classfile.Instruction;

/**
 * Created by junling on 2017/3/31.
 */
public class DADD implements Instruction {

    public byte op;

    @Override
    public byte opcode(){
        return 0x63;
    }

    @Override
    public String strcode (){
        return "dadd";
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
