package smalljvm.classfile.instruction.constant;

import smalljvm.classfile.Instruction;

/**
 * Created by junling on 2017/3/31.
 */
public class LDC_W implements Instruction {
    public byte op;
    public byte index1;
    public byte index2;

    @Override
    public byte opcode(){
        return 0x13;
    }

    @Override
    public String strcode (){
        return "ldc_w";
    }

    @Override
    public String toString() {
        return strcode() + " " + index();
    }

    @Override
    public int length() {
        return 3;
    }

    public short index() {
        int index = (index1 << 8) | (index2 & 0xFF);
        return (short)index;
    }
}
