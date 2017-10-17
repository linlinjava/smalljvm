package smalljvm.classfile.instruction.reference;

import smalljvm.classfile.Instruction;

/**
 * Created by junling on 2017/3/31.
 */
public class NEWARRAY implements Instruction {
    public byte op;
    public byte atype;

    @Override
    public byte opcode(){
        return (byte)0xbc;
    }

    @Override
    public String strcode (){
        return "newarray";
    }

    @Override
    public String toString() {
        return strcode() + " " + atype();
    }

    public byte atype(){
        return atype;
    }

    @Override
    public int length() {
        return 2;
    }
}
