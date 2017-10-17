package smalljvm.classfile.instruction.store;

import smalljvm.classfile.Instruction;

/**
 * Created by junling on 2017/3/31.
 */
public class DASTORE implements Instruction {

    public byte op;

    @Override
    public byte opcode(){
        return 0x52;
    }

    @Override
    public String strcode (){
        return "dastore";
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
