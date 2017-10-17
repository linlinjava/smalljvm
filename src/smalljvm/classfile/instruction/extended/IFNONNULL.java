package smalljvm.classfile.instruction.extended;

import smalljvm.classfile.Instruction;

/**
 * Created by junling on 2017/3/31.
 */
public class IFNONNULL implements Instruction {
    public byte op;
    public byte branch1;
    public byte branch2;

    @Override
    public byte opcode(){
        return (byte)0xc7;
    }

    @Override
    public String strcode (){
        return "ifnonnull";
    }

    @Override
    public String toString() {
        return strcode() + " " + branch();
    }

    public short branch() {
        int branch = (branch1 << 8) | (branch2 & 0xFF);
        return (short)branch;
    }

    @Override
    public int length() {
        return 3;
    }
}
