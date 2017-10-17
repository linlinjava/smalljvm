package smalljvm.classfile.instruction.math;

import smalljvm.classfile.Instruction;

/**
 * Created by junling on 2017/3/31.
 */
public class IREM implements Instruction {

    public byte op;

    @Override
    public byte opcode(){
        return 0x70;
    }

    @Override
    public String strcode (){
        return "irem";
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
