package smalljvm.classfile.instruction.store;

import smalljvm.classfile.Instruction;

/**
 * Created by junling on 2017/3/31.
 */
public class DSTORE_3 implements Instruction {

    public byte op;

    @Override
    public byte opcode(){
        return 0x4a;
    }

    @Override
    public String strcode (){
        return "dstore_3";
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
