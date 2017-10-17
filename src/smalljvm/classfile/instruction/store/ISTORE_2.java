package smalljvm.classfile.instruction.store;

import smalljvm.classfile.Instruction;

/**
 * Created by junling on 2017/3/31.
 */
public class ISTORE_2 implements Instruction {

    public byte op;

    @Override
    public byte opcode(){
        return 0x3d;
    }

    @Override
    public String strcode (){
        return "istore_2";
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
