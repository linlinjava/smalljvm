package smalljvm.classfile.instruction.store;

import smalljvm.classfile.Instruction;

/**
 * Created by junling on 2017/3/31.
 */
public class LSTORE implements Instruction {
    public byte op;
    public byte index;

    @Override
    public byte opcode(){
        return 0x37;
    }

    @Override
    public String strcode (){
        return "lstore";
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
