package smalljvm.classfile.instruction.load;

import smalljvm.classfile.Instruction;

/**
 * Created by junling on 2017/3/31.
 */
public class DLOAD_1 implements Instruction {

    public byte op;

    @Override
    public byte opcode(){
        return 0x27;
    }

    @Override
    public String strcode (){
        return "dload_1";
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
