package smalljvm.classfile.instruction.store;

import smalljvm.classfile.Instruction;

/**
 * Created by junling on 2017/3/31.
 */
public class LSTORE_1 implements Instruction {

    public byte op;

    @Override
    public byte opcode(){
        return 0x40;
    }

    @Override
    public String strcode (){
        return "lstore_1";
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
