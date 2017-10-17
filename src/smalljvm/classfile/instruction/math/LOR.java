package smalljvm.classfile.instruction.math;

import smalljvm.classfile.Instruction;

/**
 * Created by junling on 2017/3/31.
 */
public class LOR implements Instruction {

    public byte op;

    @Override
    public byte opcode(){
        return (byte)0x81;
    }

    @Override
    public String strcode (){
        return "lor";
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
