package smalljvm.classfile.instruction.control;

import smalljvm.classfile.Instruction;

/**
 * Created by junling on 2017/3/31.
 */
public class RETURN implements Instruction {

    public byte op;

    @Override
    public byte opcode(){
        return (byte)0xb1;
    }

    @Override
    public String strcode (){
        return "return";
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
