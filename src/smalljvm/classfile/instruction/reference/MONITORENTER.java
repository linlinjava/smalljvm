package smalljvm.classfile.instruction.reference;

import smalljvm.classfile.Instruction;

/**
 * Created by junling on 2017/3/31.
 */
public class MONITORENTER implements Instruction {

    public byte op;

    @Override
    public byte opcode(){
        return (byte)0xc2;
    }

    @Override
    public String strcode (){
        return "monitorenter";
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
