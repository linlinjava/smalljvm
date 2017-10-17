package smalljvm.classfile.instruction.constant;

import smalljvm.classfile.Instruction;

/**
 * Created by junling on 2017/3/31.
 */
public class LDC2_W implements Instruction {
    public byte op;
    public byte index1;
    public byte index2;

    @Override
    public byte opcode(){
        return 0x14;
    }

    @Override
    public String strcode (){
        return "ldc2_w";
    }

    @Override
    public String toString() {
        return strcode() + " " + index();
    }

    public short index(){
        int index = (index1 << 8) | (index2 & 0xFF);
        return (short)index;
    }

    @Override
    public int length() {
        return 3;
    }
}
