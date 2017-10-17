package smalljvm.classfile.instruction.load;

import smalljvm.classfile.Instruction;

/**
 * Created by junling on 2017/3/31.
 */
public class IALOAD implements Instruction {

    public byte op;

    @Override
    public byte opcode(){
        return 0x2e;
    }

    @Override
    public String strcode (){
        return "iaload";
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
