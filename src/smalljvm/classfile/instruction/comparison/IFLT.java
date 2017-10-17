package smalljvm.classfile.instruction.comparison;

import smalljvm.classfile.Instruction;

/**
 * Created by junling on 2017/3/31.
 */
public class IFLT implements Instruction {

    public byte op;
    public byte branch1;
    public byte branch2;

    @Override
    public byte opcode(){
        return (byte)0x9b;
    }

    @Override
    public String strcode (){
        return "iflt";
    }

    @Override
    public String toString(){
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
