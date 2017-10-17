package smalljvm.classfile.instruction.load;

import smalljvm.classfile.Instruction;

/**
 * Created by junling on 2017/3/31.
 */
public class ALOAD implements Instruction {
    public byte op;
    public byte index;

    @Override
    public byte opcode(){
        return 0x19;
    }

    @Override
    public String strcode (){
        return "aload";
    }

    @Override
    public String toString() {
        return strcode() + " " + index();
    }

    public byte index(){
        return index;
    }

    @Override
    public int length() {
        return 2;
    }
}
