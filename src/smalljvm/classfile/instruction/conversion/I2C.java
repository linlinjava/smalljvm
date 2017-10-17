package smalljvm.classfile.instruction.conversion;

import smalljvm.classfile.Instruction;

/**
 * Created by junling on 2017/3/31.
 */
public class I2C implements Instruction {

    public byte op;

    @Override
    public byte opcode(){
        return (byte)0x92;
    }

    @Override
    public String strcode (){
        return "i2c";
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
