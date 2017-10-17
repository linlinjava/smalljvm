package smalljvm.classfile.instruction.extended;

import smalljvm.classfile.Instruction;

/**
 * Created by junling on 2017/3/31.
 */
public class GOTO_W implements Instruction {
    public byte op;
    public byte branch1;
    public byte branch2;
    public byte branch3;
    public byte branch4;

    @Override
    public byte opcode(){
        return (byte)0xc8;
    }

    @Override
    public String strcode (){
        return "goto_w";
    }

    @Override
    public String toString() {
        return strcode() + " " + branch();
    }

    public int branch(){
        int branch = (branch1 << 24) | (branch2 << 16) | (branch3 << 8) | (branch4 & 0xFF);
        return branch;
    }

    @Override
    public int length() {
        return 5;
    }
}
