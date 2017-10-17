package smalljvm.classfile.instruction.stack;

import smalljvm.classfile.Instruction;

/**
 * Created by junling on 2017/3/31.
 */
public class DUP2 implements Instruction {

    public byte op;

    @Override
    public byte opcode(){
        return 0x5c;
    }

    @Override
    public String strcode (){
        return "dup2";
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
