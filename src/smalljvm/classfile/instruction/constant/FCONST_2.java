package smalljvm.classfile.instruction.constant;

import smalljvm.classfile.Instruction;

/**
 * Created by junling on 2017/3/31.
 */
public class FCONST_2 implements Instruction {
    public byte op;

    @Override
    public byte opcode(){
        return 0xd;
    }

    @Override
    public String strcode (){
        return "fconst_2";
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
