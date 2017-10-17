package smalljvm.classfile.instruction.constant;

import smalljvm.classfile.Instruction;

/**
 * Created by junling on 2017/3/31.
 */
public class SIPUSH implements Instruction {
    public byte op;
    public byte value1;
    public byte value2;

    @Override
    public byte opcode(){
        return 0x11;
    }

    @Override
    public String strcode (){
        return "sipush";
    }

    public short value() {
        int data = (value1 << 8 ) | (value2 & 0xFF);
        return (short)data;
    }

    @Override
    public String toString() {
        return strcode() + " " + value();
    }

    @Override
    public int length() {
        return 3;
    }
}
