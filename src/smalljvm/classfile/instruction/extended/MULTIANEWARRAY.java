package smalljvm.classfile.instruction.extended;

import smalljvm.classfile.Instruction;

/**
 * Created by junling on 2017/3/31.
 */
public class MULTIANEWARRAY implements Instruction {
    public byte op;
    public byte index1;
    public byte index2;
    public byte dimensions;

    @Override
    public byte opcode(){
        return (byte)0xc5;
    }

    @Override
    public String strcode (){
        return "multianewarray";
    }

    @Override
    public String toString() {
        return strcode() + " " + index() + " " + dimensions();
    }

    @Override
    public int length() {
        return 4;
    }

    public short index(){
        int index = (index1 << 8) | (index2 & 0xFF);
        return (short)index;
    }

    public byte dimensions(){
        return dimensions;
    }
}
