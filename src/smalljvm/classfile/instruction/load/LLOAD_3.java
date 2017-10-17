package smalljvm.classfile.instruction.load;

import smalljvm.classfile.Instruction;

/**
 * Created by junling on 2017/3/31.
 */
public class LLOAD_3 implements Instruction {

    public byte op;

    @Override
    public byte opcode(){
        return 0x21;
    }

    @Override
    public String strcode (){
        return "lload_3";
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
