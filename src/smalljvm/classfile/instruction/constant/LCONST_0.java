package smalljvm.classfile.instruction.constant;

import smalljvm.classfile.Instruction;

/**
 * Created by junling on 2017/3/31.
 */
public class LCONST_0 implements Instruction {

    public byte op;

    @Override
    public byte opcode(){
        return 0x09;
    }

    @Override
    public String strcode (){
        return "lconst_0";
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
