package smalljvm.classfile.instruction.extended;

import smalljvm.classfile.Env;
import smalljvm.classfile.Instruction;

/**
 * Created by junling on 2017/3/31.
 */
public class WIDE implements Instruction {
    public byte op;
    public byte nopcode;
    public byte index1;
    public byte index2;
    public byte const1;
    public byte const2;

    @Override
    public byte opcode(){
        return (byte)0xc4;
    }

    @Override
    public String strcode (){
        return "wide";
    }

    @Override
    public String toString() {
        switch (nopcode)
        {
            case Env.INSTRUCTION_OPCODE_ILOAD:
            case Env.INSTRUCTION_OPCODE_LLOAD:
            case Env.INSTRUCTION_OPCODE_FLOAD:
            case Env.INSTRUCTION_OPCODE_DLOAD:
            case Env.INSTRUCTION_OPCODE_ALOAD:
            case Env.INSTRUCTION_OPCODE_ILOAD_0:
            case Env.INSTRUCTION_OPCODE_ILOAD_1:
            case Env.INSTRUCTION_OPCODE_ILOAD_2:
            case Env.INSTRUCTION_OPCODE_ILOAD_3:
            case Env.INSTRUCTION_OPCODE_LLOAD_0:
            case Env.INSTRUCTION_OPCODE_LLOAD_1:
            case Env.INSTRUCTION_OPCODE_LLOAD_2:
            case Env.INSTRUCTION_OPCODE_LLOAD_3:
            case Env.INSTRUCTION_OPCODE_FLOAD_0:
            case Env.INSTRUCTION_OPCODE_FLOAD_1:
            case Env.INSTRUCTION_OPCODE_FLOAD_2:
            case Env.INSTRUCTION_OPCODE_FLOAD_3:
            case Env.INSTRUCTION_OPCODE_DLOAD_0:
            case Env.INSTRUCTION_OPCODE_DLOAD_1:
            case Env.INSTRUCTION_OPCODE_DLOAD_2:
            case Env.INSTRUCTION_OPCODE_DLOAD_3:
            case Env.INSTRUCTION_OPCODE_ALOAD_0:
            case Env.INSTRUCTION_OPCODE_ALOAD_1:
            case Env.INSTRUCTION_OPCODE_ALOAD_2:
            case Env.INSTRUCTION_OPCODE_ALOAD_3:

            case Env.INSTRUCTION_OPCODE_ISTORE:
            case Env.INSTRUCTION_OPCODE_LSTORE:
            case Env.INSTRUCTION_OPCODE_FSTORE:
            case Env.INSTRUCTION_OPCODE_DSTORE:
            case Env.INSTRUCTION_OPCODE_ASTORE:
            case Env.INSTRUCTION_OPCODE_ISTORE_0:
            case Env.INSTRUCTION_OPCODE_ISTORE_1:
            case Env.INSTRUCTION_OPCODE_ISTORE_2:
            case Env.INSTRUCTION_OPCODE_ISTORE_3:
            case Env.INSTRUCTION_OPCODE_LSTORE_0:
            case Env.INSTRUCTION_OPCODE_LSTORE_1:
            case Env.INSTRUCTION_OPCODE_LSTORE_2:
            case Env.INSTRUCTION_OPCODE_LSTORE_3:
            case Env.INSTRUCTION_OPCODE_FSTORE_0:
            case Env.INSTRUCTION_OPCODE_FSTORE_1:
            case Env.INSTRUCTION_OPCODE_FSTORE_2:
            case Env.INSTRUCTION_OPCODE_FSTORE_3:
            case Env.INSTRUCTION_OPCODE_DSTORE_0:
            case Env.INSTRUCTION_OPCODE_DSTORE_1:
            case Env.INSTRUCTION_OPCODE_DSTORE_2:
            case Env.INSTRUCTION_OPCODE_DSTORE_3:
            case Env.INSTRUCTION_OPCODE_ASTORE_0:
            case Env.INSTRUCTION_OPCODE_ASTORE_1:
            case Env.INSTRUCTION_OPCODE_ASTORE_2:
            case Env.INSTRUCTION_OPCODE_ASTORE_3:
            case Env.INSTRUCTION_OPCODE_RET:
                return strcode() + " " + String.valueOf(nopcode) + " " + index();
            case Env.INSTRUCTION_OPCODE_IINC:
                return strcode() + " " + String.valueOf(nopcode) + " " + index() + " " + constant();
            default:
                return "WRONG OPCODE!!!";
        }
    }

    @Override
    public int length() {
        throw new IllegalStateException("");
    }

    public short index(){
        int index = (index1 << 8) | (index2 & 0xFF);
        return (short)index;
    }

    public short constant(){
        int constant = (const1 << 8) | (const2 & 0xFF);
        return (short)constant;
    }
}
