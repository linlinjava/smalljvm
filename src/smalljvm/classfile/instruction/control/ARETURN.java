package smalljvm.classfile.instruction.control;

import smalljvm.classfile.Instruction;

/**
 * Created by junling on 2017/3/31.
 */
public class ARETURN implements Instruction {

    public byte op;

    @Override
    public byte opcode(){
        return (byte)0xb0;
    }

    @Override
    public String strcode (){
        return "areturn";
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
