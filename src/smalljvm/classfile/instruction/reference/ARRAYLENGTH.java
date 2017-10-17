package smalljvm.classfile.instruction.reference;

import smalljvm.classfile.Instruction;

/**
 * Created by junling on 2017/3/31.
 */
public class ARRAYLENGTH implements Instruction {

    public byte op;

    @Override
    public byte opcode(){
        return (byte)0xbe;
    }

    @Override
    public String strcode (){
        return "arraylength";
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
