package smalljvm.classfile.instruction.stack;

import smalljvm.classfile.Instruction;

/**
 * Created by junling on 2017/3/31.
 */
public class DUP_X2 implements Instruction {

    public byte op;

    @Override
    public byte opcode(){
        return 0x5b;
    }

    @Override
    public String strcode (){
        return "dup_x2";
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
