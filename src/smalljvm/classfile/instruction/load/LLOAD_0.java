package smalljvm.classfile.instruction.load;

import smalljvm.classfile.Instruction;

/**
 * Created by junling on 2017/3/31.
 */
public class LLOAD_0 implements Instruction {

    public byte op;

    @Override
    public byte opcode(){
        return 0x1e;
    }

    @Override
    public String strcode (){
        return "lload_0";
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
