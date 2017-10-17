package smalljvm.classfile.instruction.constant;

import smalljvm.classfile.Instruction;

/**
 * Created by junling on 2017/3/31.
 */
public class ICONST_3 implements Instruction {
    public byte op;

    @Override
    public byte opcode(){
        return 0x6;
    }

    @Override
    public String strcode (){
        return "iconst_3";
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
