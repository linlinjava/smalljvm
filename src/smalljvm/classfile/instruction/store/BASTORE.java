package smalljvm.classfile.instruction.store;

import smalljvm.classfile.Instruction;

/**
 * Created by junling on 2017/3/31.
 */
public class BASTORE implements Instruction {

    public byte op;

    @Override
    public byte opcode(){
        return 0x54;
    }

    @Override
    public String strcode (){
        return "bastore";
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
