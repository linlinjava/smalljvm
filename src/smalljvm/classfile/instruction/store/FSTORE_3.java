package smalljvm.classfile.instruction.store;

import smalljvm.classfile.Instruction;

/**
 * Created by junling on 2017/3/31.
 */
public class FSTORE_3 implements Instruction {

    public byte op;

    @Override
    public byte opcode(){
        return 0x46;
    }

    @Override
    public String strcode (){
        return "fstore_3";
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
