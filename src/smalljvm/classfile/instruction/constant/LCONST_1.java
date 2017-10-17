package smalljvm.classfile.instruction.constant;

import smalljvm.classfile.Instruction;

/**
 * Created by junling on 2017/3/31.
 */
public class LCONST_1 implements Instruction {

    public byte op;

    @Override
    public byte opcode(){
        return 0x0a;
    }

    @Override
    public String strcode (){
        return "lconst_1";
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
