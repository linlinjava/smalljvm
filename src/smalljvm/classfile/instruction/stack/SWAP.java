package smalljvm.classfile.instruction.stack;

import smalljvm.classfile.Instruction;

/**
 * Created by junling on 2017/3/31.
 */
public class SWAP implements Instruction {

    public byte op;

    @Override
    public byte opcode(){
        return 0x5f;
    }

    @Override
    public String strcode (){
        return "swap";
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
