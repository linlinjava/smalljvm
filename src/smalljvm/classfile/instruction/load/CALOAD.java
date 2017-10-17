package smalljvm.classfile.instruction.load;

import smalljvm.classfile.Instruction;

/**
 * Created by junling on 2017/3/31.
 */
public class CALOAD implements Instruction {

    public byte op;

    @Override
    public byte opcode(){
        return 0x34;
    }

    @Override
    public String strcode (){
        return "caload";
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
