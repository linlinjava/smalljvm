package smalljvm.classfile.instruction.load;

import smalljvm.classfile.Instruction;

/**
 * Created by junling on 2017/3/31.
 */
public class FALOAD implements Instruction {

    public byte op;

    @Override
    public byte opcode(){
        return 0x30;
    }

    @Override
    public String strcode (){
        return "faload";
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
