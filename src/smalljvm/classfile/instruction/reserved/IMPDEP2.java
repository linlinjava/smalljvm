package smalljvm.classfile.instruction.reserved;

import smalljvm.classfile.Instruction;

/**
 * Created by junling on 2017/3/31.
 */
public class IMPDEP2 implements Instruction {

    public byte op;

    @Override
    public byte opcode(){
        return (byte)0xff;
    }

    @Override
    public String strcode (){
        return "impdep2";
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
