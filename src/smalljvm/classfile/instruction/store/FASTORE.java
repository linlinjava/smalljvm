package smalljvm.classfile.instruction.store;

import smalljvm.classfile.Instruction;

/**
 * Created by junling on 2017/3/31.
 */
public class FASTORE implements Instruction {

    public byte op;

    @Override
    public byte opcode(){
        return 0x51;
    }

    @Override
    public String strcode (){
        return "fastore";
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
