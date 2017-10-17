package smalljvm.classfile.instruction.reference;

import smalljvm.classfile.Instruction;

/**
 * Created by junling on 2017/3/31.
 */
public class MONITOREXIT implements Instruction {

    public byte op;

    @Override
    public byte opcode(){
        return (byte)0xc3;
    }

    @Override
    public String strcode (){
        return "monitorexit";
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
