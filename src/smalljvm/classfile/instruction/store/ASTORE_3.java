package smalljvm.classfile.instruction.store;

import smalljvm.classfile.Instruction;

/**
 * Created by junling on 2017/3/31.
 */
public class ASTORE_3 implements Instruction {

    public byte op;

    @Override
    public byte opcode(){
        return 0x4e;
    }

    @Override
    public String strcode (){
        return "astore_3";
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
