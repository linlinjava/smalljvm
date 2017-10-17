package smalljvm.classfile.instruction.constant;

import smalljvm.classfile.Instruction;

/**
 * Created by junling on 2017/3/31.
 */
public class FCONST_0 implements Instruction {

    public byte op;

    @Override
    public byte opcode(){
        return 0xb;
    }

    @Override
    public String strcode (){
        return "fconst_0";
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
