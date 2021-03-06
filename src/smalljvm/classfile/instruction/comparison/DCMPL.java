package smalljvm.classfile.instruction.comparison;

import smalljvm.classfile.Instruction;

/**
 * Created by junling on 2017/3/31.
 */
public class DCMPL implements Instruction {

    public byte op;

    @Override
    public byte opcode(){
        return (byte)0x97;
    }

    @Override
    public String strcode (){
        return "dcmpl";
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
