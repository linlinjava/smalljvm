package smalljvm.classfile.instruction.stack;

import smalljvm.classfile.Instruction;

/**
 * Created by junling on 2017/3/31.
 */
public class POP2 implements Instruction {

    public byte op;

    @Override
    public byte opcode(){
        return 0x58;
    }

    @Override
    public String strcode (){
        return "pop2";
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
