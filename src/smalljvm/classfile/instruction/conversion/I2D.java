package smalljvm.classfile.instruction.conversion;

import smalljvm.classfile.Instruction;

/**
 * Created by junling on 2017/3/31.
 */
public class I2D implements Instruction {

    public byte op;

    @Override
    public byte opcode(){
        return (byte)0x87;
    }

    @Override
    public String strcode (){
        return "i2d";
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
