package smalljvm.classfile.instruction.reference;

import smalljvm.classfile.Instruction;

/**
 * Created by junling on 2017/3/31.
 */
public class ATHROW implements Instruction {

    public byte op;

    @Override
    public byte opcode(){
        return (byte)0xbf;
    }

    @Override
    public String strcode (){
        return "athrow";
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
