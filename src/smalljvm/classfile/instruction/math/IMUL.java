package smalljvm.classfile.instruction.math;

import smalljvm.classfile.Instruction;

/**
 * Created by junling on 2017/3/31.
 */
public class IMUL implements Instruction {

    public byte op;

    @Override
    public byte opcode(){
        return 0x68;
    }

    @Override
    public String strcode (){
        return "imul";
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
