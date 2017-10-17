package smalljvm.classfile.instruction.math;

import smalljvm.classfile.Instruction;

/**
 * Created by junling on 2017/3/31.
 */
public class IUSHR implements Instruction {

    public byte op;

    @Override
    public byte opcode(){
        return 0x7c;
    }

    @Override
    public String strcode (){
        return "iushr";
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
