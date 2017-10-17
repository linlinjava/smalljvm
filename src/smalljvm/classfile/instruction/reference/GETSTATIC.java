package smalljvm.classfile.instruction.reference;

import smalljvm.classfile.Instruction;

/**
 * Created by junling on 2017/3/31.
 */
public class GETSTATIC implements Instruction {
    public byte op;
    public byte index1;
    public byte index2;

    @Override
    public byte opcode(){
        return (byte)0xb2;
    }

    @Override
    public String strcode (){
        return "getstatic";
    }

    @Override
    public String toString() {
        return strcode() + " " + index();
    }

    public short index() {
        int index = (index1 << 8) | (index2 & 0xFF);
        return (short)index;
    }

    @Override
    public int length() {
        return 3;
    }
}
