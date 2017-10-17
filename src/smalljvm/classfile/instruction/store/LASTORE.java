package smalljvm.classfile.instruction.store;

import smalljvm.classfile.Instruction;

/**
 * Created by junling on 2017/3/31.
 */
public class LASTORE implements Instruction {

    public byte op;

    @Override
    public byte opcode(){
        return 0x50;
    }

    @Override
    public String strcode (){
        return "lastore";
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
