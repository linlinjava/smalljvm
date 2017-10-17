package smalljvm.classfile.instruction.reserved;

import smalljvm.classfile.Instruction;

/**
 * Created by junling on 2017/3/31.
 */
public class IMPDEP1 implements Instruction {

    public byte op;

    @Override
    public byte opcode(){
        return (byte)0xfe;
    }

    @Override
    public String strcode (){
        return "impdep1";
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
