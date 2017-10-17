package smalljvm.classfile.instruction.constant;

import smalljvm.classfile.Instruction;

/**
 * Created by junling on 2017/3/31.
 */
public class ACONST_NULL implements Instruction {

    public byte op;

    @Override
    public byte opcode(){
        return 0x01;
    }

    @Override
    public String strcode (){
        return "aconst_null";
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
