package smalljvm.classfile.instruction.constant;

import smalljvm.classfile.Instruction;

/**
 * Created by junling on 2017/3/31.
 */
public class NOP implements Instruction {

    public byte op;

    @Override
    public byte opcode(){
        return 0x00;
    }

    @Override
    public String strcode (){
        return "nop";
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
