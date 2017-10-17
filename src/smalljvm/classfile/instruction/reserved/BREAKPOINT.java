package smalljvm.classfile.instruction.reserved;

import smalljvm.classfile.Instruction;

/**
 * Created by junling on 2017/3/31.
 */
public class BREAKPOINT implements Instruction {

    public byte op;

    @Override
    public byte opcode(){
        return (byte)0xca;
    }

    @Override
    public String strcode (){
        return "breakpoint";
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
