package smalljvm.classfile.instruction.load;

import smalljvm.classfile.Instruction;

/**
 * Created by junling on 2017/3/31.
 */
public class DLOAD_0 implements Instruction {

    public byte op;

    @Override
    public byte opcode(){
        return 0x26;
    }

    @Override
    public String strcode (){
        return "dload_0";
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
