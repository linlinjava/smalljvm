package smalljvm.classfile.instruction.reference;

import smalljvm.classfile.Instruction;

/**
 * Created by junling on 2017/3/31.
 */
public class INVOKEINTERFACE implements Instruction {
    public byte op;
    public byte index1;
    public byte index2;
    public byte count;

    @Override
    public byte opcode(){
        return (byte)0xb9;
    }

    @Override
    public String strcode (){
        return "invokeinterface";
    }

    @Override
    public String toString() {
        return strcode() + " " + index() + " " + count();
    }

    public short index(){
        int index = (index1 << 8) | (index2 & 0xFF);
        return (short)index;
    }

    public byte count(){
        return count;
    }

    @Override
    public int length() {
        return 4;
    }
}
