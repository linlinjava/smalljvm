package smalljvm.classfile.instruction.store;

import smalljvm.classfile.Instruction;

/**
 * Created by junling on 2017/3/31.
 */
public class ISTORE_0 implements Instruction {

    public byte op;

    @Override
    public byte opcode(){
        return 0x3b;
    }

    @Override
    public String strcode (){
        return "istore_0";
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
