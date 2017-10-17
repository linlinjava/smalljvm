package smalljvm.classfile.instruction.conversion;

import smalljvm.classfile.Instruction;

/**
 * Created by junling on 2017/3/31.
 */
public class L2I implements Instruction {

    public byte op;

    @Override
    public byte opcode(){
        return (byte)0x88;
    }

    @Override
    public String strcode (){
        return "l2i";
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
