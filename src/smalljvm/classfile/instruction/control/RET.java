package smalljvm.classfile.instruction.control;

import smalljvm.classfile.Instruction;

/**
 * Created by junling on 2017/3/31.
 */
public class RET implements Instruction {

    public byte op;

    @Override
    public byte opcode(){
        return (byte)0xa9;
    }

    @Override
    public String strcode (){
        return "ret";
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
