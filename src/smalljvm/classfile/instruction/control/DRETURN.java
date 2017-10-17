package smalljvm.classfile.instruction.control;

import smalljvm.classfile.Instruction;

/**
 * Created by junling on 2017/3/31.
 */
public class DRETURN implements Instruction {

    public byte op;

    @Override
    public byte opcode(){
        return (byte)0xaf;
    }

    @Override
    public String strcode (){
        return "dreturn";
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
