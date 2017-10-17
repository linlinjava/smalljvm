package smalljvm.classfile.instruction.math;

import smalljvm.classfile.Instruction;

/**
 * Created by junling on 2017/3/31.
 */
public class IOR implements Instruction {

    public byte op;

    @Override
    public byte opcode(){
        return (byte)0x80;
    }

    @Override
    public String strcode (){
        return "ior";
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
