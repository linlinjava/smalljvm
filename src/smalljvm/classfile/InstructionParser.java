package smalljvm.classfile;

import smalljvm.classfile.instruction.comparison.*;
import smalljvm.classfile.instruction.constant.*;
import smalljvm.classfile.instruction.control.*;
import smalljvm.classfile.instruction.conversion.*;
import smalljvm.classfile.instruction.extended.*;
import smalljvm.classfile.instruction.load.*;
import smalljvm.classfile.instruction.math.*;
import smalljvm.classfile.instruction.reference.*;
import smalljvm.classfile.instruction.reserved.BREAKPOINT;
import smalljvm.classfile.instruction.reserved.IMPDEP1;
import smalljvm.classfile.instruction.reserved.IMPDEP2;
import smalljvm.classfile.instruction.stack.*;
import smalljvm.classfile.instruction.store.*;
import static smalljvm.classfile.Env.*;

import java.io.IOException;
import java.util.Vector;


/**
 * Created by junling on 2017/3/20.
 */
public class InstructionParser{

    private byte[] code = new byte[0];
    private int index = 0;


    public static Instruction[] parse(byte[] codes){
        Vector<Instruction> instructions = new Vector<Instruction>();
        InstructionParser parser = new InstructionParser(codes, 0);
        while(parser.hasNext()){
            instructions.add(parser.next());
        }
        return instructions.toArray(new Instruction[0]);
    }

    public static Instruction parse(byte[] codes, int pc){
        InstructionParser parser = new InstructionParser(codes, pc);
        return parser.next();
    }

    private InstructionParser(byte[] data, int pc){
        code = data;
        index = pc;
    }

    private Instruction next(){
            byte opcode = code[index++];

            switch (opcode) {
                // constant instructions
                case INSTRUCTION_OPCODE_NOP:
                    return new NOP();
                case INSTRUCTION_OPCODE_ACONST_NULL:
                    return new ACONST_NULL();
                case INSTRUCTION_OPCODE_ICONST_M1:
                    return new ICONST_M1();
                case INSTRUCTION_OPCODE_ICONST_0:
                    return new ICONST_0();
                case INSTRUCTION_OPCODE_ICONST_1:
                    return new ICONST_1();
                case INSTRUCTION_OPCODE_ICONST_2:
                    return new ICONST_2();
                case INSTRUCTION_OPCODE_ICONST_3:
                    return new ICONST_3();
                case INSTRUCTION_OPCODE_ICONST_4:
                    return new ICONST_4();
                case INSTRUCTION_OPCODE_ICONST_5:
                    return new ICONST_5();
                case INSTRUCTION_OPCODE_LCONST_0:
                    return new LCONST_0();
                case INSTRUCTION_OPCODE_LCONST_1:
                    return new LCONST_1();
                case INSTRUCTION_OPCODE_FCONST_0:
                    return new FCONST_0();
                case INSTRUCTION_OPCODE_FCONST_1:
                    return new FCONST_1();
                case INSTRUCTION_OPCODE_FCONST_2:
                    return new FCONST_2();
                case INSTRUCTION_OPCODE_DCONST_0:
                    return new DCONST_0();
                case INSTRUCTION_OPCODE_DCONST_1:
                    return new DCONST_1();
                case INSTRUCTION_OPCODE_BIPUSH:
                    BIPUSH bipush = new BIPUSH();
                    bipush.value = code[index++];
                    return bipush;
                case INSTRUCTION_OPCODE_SIPUSH:
                    SIPUSH sipush = new SIPUSH();
                    sipush.value1 = code[index++];
                    sipush.value2 = code[index++];
                    return sipush;
                case INSTRUCTION_OPCODE_LDC:
                    LDC ldc = new LDC();
                    ldc.index = code[index++];
                    return ldc;
                case INSTRUCTION_OPCODE_LDC_W:
                    LDC_W ldcw = new LDC_W();
                    ldcw.index1 = code[index++];
                    ldcw.index2 = code[index++];
                    return ldcw;
                case INSTRUCTION_OPCODE_LDC2_W:
                    LDC2_W ldc2w = new LDC2_W();
                    ldc2w.index1 = code[index++];
                    ldc2w.index2 = code[index++];
                    return ldc2w;

                // load instructions
                case INSTRUCTION_OPCODE_ALOAD:
                    ALOAD aload = new ALOAD();
                    aload.index = code[index++];
                    return aload;
                case INSTRUCTION_OPCODE_ALOAD_0:
                    return new ALOAD_0();
                case INSTRUCTION_OPCODE_ALOAD_1:
                    return new ALOAD_1();
                case INSTRUCTION_OPCODE_ALOAD_2:
                    return new ALOAD_2();
                case INSTRUCTION_OPCODE_ALOAD_3:
                    return new ALOAD_3();
                case INSTRUCTION_OPCODE_DLOAD:
                    DLOAD dload = new DLOAD();
                    dload.index = code[index++];
                    return dload;
                case INSTRUCTION_OPCODE_DLOAD_0:
                    return new DLOAD_0();
                case INSTRUCTION_OPCODE_DLOAD_1:
                    return new DLOAD_1();
                case INSTRUCTION_OPCODE_DLOAD_2:
                    return new DLOAD_2();
                case INSTRUCTION_OPCODE_DLOAD_3:
                    return new DLOAD_3();
                case INSTRUCTION_OPCODE_FLOAD:
                    FLOAD fload = new FLOAD();
                    fload.index = code[index++];
                    return fload;
                case INSTRUCTION_OPCODE_FLOAD_0:
                    return new FLOAD_0();
                case INSTRUCTION_OPCODE_FLOAD_1:
                    return new FLOAD_1();
                case INSTRUCTION_OPCODE_FLOAD_2:
                    return new FLOAD_2();
                case INSTRUCTION_OPCODE_FLOAD_3:
                    return new FLOAD_3();
                case INSTRUCTION_OPCODE_ILOAD:
                    ILOAD iload = new ILOAD();
                    iload.index = code[index++];
                    return iload;
                case INSTRUCTION_OPCODE_ILOAD_0:
                    return new ILOAD_0();
                case INSTRUCTION_OPCODE_ILOAD_1:
                    return new ILOAD_1();
                case INSTRUCTION_OPCODE_ILOAD_2:
                    return new ILOAD_2();
                case INSTRUCTION_OPCODE_ILOAD_3:
                    return new ILOAD_3();
                case INSTRUCTION_OPCODE_LLOAD:
                    LLOAD lload = new LLOAD();
                    lload.index = code[index++];
                    return lload;
                case INSTRUCTION_OPCODE_LLOAD_0:
                    return new LLOAD_0();
                case INSTRUCTION_OPCODE_LLOAD_1:
                    return new LLOAD_1();
                case INSTRUCTION_OPCODE_LLOAD_2:
                    return new LLOAD_2();
                case INSTRUCTION_OPCODE_LLOAD_3:
                    return new LLOAD_3();
                case INSTRUCTION_OPCODE_LALOAD:
                    return new LALOAD();
                case INSTRUCTION_OPCODE_SALOAD:
                    return new SALOAD();
                case INSTRUCTION_OPCODE_AALOAD:
                    return new AALOAD();
                case INSTRUCTION_OPCODE_IALOAD:
                    return new IALOAD();
                case INSTRUCTION_OPCODE_FALOAD:
                    return new FALOAD();
                case INSTRUCTION_OPCODE_DALOAD:
                    return new DALOAD();
                case INSTRUCTION_OPCODE_BALOAD:
                    return new BALOAD();
                case INSTRUCTION_OPCODE_CALOAD:
                    return new CALOAD();

                // math11 instructions
                case INSTRUCTION_OPCODE_DADD:
                    return new DADD();
                case INSTRUCTION_OPCODE_DDIV:
                    return new DDIV();
                case INSTRUCTION_OPCODE_DMUL:
                    return new DMUL();
                case INSTRUCTION_OPCODE_DNEG:
                    return new DNEG();
                case INSTRUCTION_OPCODE_DREM:
                    return new DREM();
                case INSTRUCTION_OPCODE_DSUB:
                    return new DSUB();
                case INSTRUCTION_OPCODE_FADD:
                    return new FADD();
                case INSTRUCTION_OPCODE_FDIV:
                    return new FDIV();
                case INSTRUCTION_OPCODE_FMUL:
                    return new FMUL();
                case INSTRUCTION_OPCODE_FNEG:
                    return new FNEG();
                case INSTRUCTION_OPCODE_FREM:
                    return new FREM();
                case INSTRUCTION_OPCODE_FSUB:
                    return new FSUB();
                case INSTRUCTION_OPCODE_IADD:
                    return new IADD();
                case INSTRUCTION_OPCODE_IAND:
                    return new IAND();
                case INSTRUCTION_OPCODE_IDIV:
                    return new IDIV();
                case INSTRUCTION_OPCODE_IINC:
                    IINC iinc = new IINC();
                    iinc.index = code[index++];
                    iinc.constant = code[index++];
                    return iinc;
                case INSTRUCTION_OPCODE_IMUL:
                    return new IMUL();
                case INSTRUCTION_OPCODE_INEG:
                    return new INEG();
                case INSTRUCTION_OPCODE_IOR:
                    return new IOR();
                case INSTRUCTION_OPCODE_IREM:
                    return new IREM();
                case INSTRUCTION_OPCODE_ISHL:
                    return new ISHL();
                case INSTRUCTION_OPCODE_ISHR:
                    return new ISHR();
                case INSTRUCTION_OPCODE_ISUB:
                    return new ISUB();
                case INSTRUCTION_OPCODE_IUSHR:
                    return new IUSHR();
                case INSTRUCTION_OPCODE_IXOR:
                    return new IXOR();
                case INSTRUCTION_OPCODE_LADD:
                    return new LADD();
                case INSTRUCTION_OPCODE_LAND:
                    return new LAND();
                case INSTRUCTION_OPCODE_LDIV:
                    return new LDIV();
                case INSTRUCTION_OPCODE_LMUL:
                    return new LMUL();
                case INSTRUCTION_OPCODE_LNEG:
                    return new LNEG();
                case INSTRUCTION_OPCODE_LOR:
                    return new LOR();
                case INSTRUCTION_OPCODE_LREM:
                    return new LREM();
                case INSTRUCTION_OPCODE_LSHL:
                    return new LSHL();
                case INSTRUCTION_OPCODE_LSHR:
                    return new LSHR();
                case INSTRUCTION_OPCODE_LSUB:
                    return new LSUB();
                case INSTRUCTION_OPCODE_LUSHR:
                    return new LUSHR();
                case INSTRUCTION_OPCODE_LXOR:
                    return new LXOR();

                // store instructions
                case INSTRUCTION_OPCODE_ASTORE:
                    ASTORE astore = new ASTORE();
                    astore.index = code[index++];
                    return astore;
                case INSTRUCTION_OPCODE_ASTORE_0:
                    return new ASTORE_0();
                case INSTRUCTION_OPCODE_ASTORE_1:
                    return new ASTORE_1();
                case INSTRUCTION_OPCODE_ASTORE_2:
                    return new ASTORE_2();
                case INSTRUCTION_OPCODE_ASTORE_3:
                    return new ASTORE_3();
                case INSTRUCTION_OPCODE_DSTORE:
                    DSTORE dstore = new DSTORE();
                    dstore.index = code[index++];
                    return dstore;
                case INSTRUCTION_OPCODE_DSTORE_0:
                    return new DSTORE_0();
                case INSTRUCTION_OPCODE_DSTORE_1:
                    return new DSTORE_1();
                case INSTRUCTION_OPCODE_DSTORE_2:
                    return new DSTORE_2();
                case INSTRUCTION_OPCODE_DSTORE_3:
                    return new DSTORE_3();
                case INSTRUCTION_OPCODE_FSTORE:
                    FSTORE fstore = new FSTORE();
                    fstore.index = code[index++];
                    return fstore;
                case INSTRUCTION_OPCODE_FSTORE_0:
                    return new FSTORE_0();
                case INSTRUCTION_OPCODE_FSTORE_1:
                    return new FSTORE_1();
                case INSTRUCTION_OPCODE_FSTORE_2:
                    return new FSTORE_2();
                case INSTRUCTION_OPCODE_FSTORE_3:
                    return new FSTORE_3();
                case INSTRUCTION_OPCODE_ISTORE:
                    ISTORE istore = new ISTORE();
                    istore.index = code[index++];
                    return istore;
                case INSTRUCTION_OPCODE_ISTORE_0:
                    return new ISTORE_0();
                case INSTRUCTION_OPCODE_ISTORE_1:
                    return new ISTORE_1();
                case INSTRUCTION_OPCODE_ISTORE_2:
                    return new ISTORE_2();
                case INSTRUCTION_OPCODE_ISTORE_3:
                    return new ISTORE_3();
                case INSTRUCTION_OPCODE_LSTORE:
                    LSTORE lstore = new LSTORE();
                    lstore.index = code[index++];
                    return lstore;
                case INSTRUCTION_OPCODE_LSTORE_0:
                    return new LSTORE_0();
                case INSTRUCTION_OPCODE_LSTORE_1:
                    return new LSTORE_1();
                case INSTRUCTION_OPCODE_LSTORE_2:
                    return new LSTORE_2();
                case INSTRUCTION_OPCODE_LSTORE_3:
                    return new LSTORE_3();
                case INSTRUCTION_OPCODE_AASTORE:
                    return new AASTORE();
                case INSTRUCTION_OPCODE_BASTORE:
                    return new BASTORE();
                case INSTRUCTION_OPCODE_CASTORE:
                    return new CASTORE();
                case INSTRUCTION_OPCODE_DASTORE:
                    return new DASTORE();
                case INSTRUCTION_OPCODE_FASTORE:
                    return new FASTORE();
                case INSTRUCTION_OPCODE_IASTORE:
                    return new IASTORE();
                case INSTRUCTION_OPCODE_LASTORE:
                    return new LASTORE();
                case INSTRUCTION_OPCODE_SASTORE:
                    return new SASTORE();

                // stack instructions
                case INSTRUCTION_OPCODE_POP:
                    return new POP();
                case INSTRUCTION_OPCODE_POP2:
                    return new POP2();
                case INSTRUCTION_OPCODE_DUP:
                    return new DUP();
                case INSTRUCTION_OPCODE_DUP_X1:
                    return new DUP2_X1();
                case INSTRUCTION_OPCODE_DUP_X2:
                    return new DUP_X2();
                case INSTRUCTION_OPCODE_DUP2:
                    return new DUP2();
                case INSTRUCTION_OPCODE_DUP2_X1:
                    return new DUP2_X1();
                case INSTRUCTION_OPCODE_DUP2_X2:
                    return new DUP2_X2();
                case INSTRUCTION_OPCODE_SWAP:
                    return new SWAP();

                // conversion instructions
                case INSTRUCTION_OPCODE_I2L:
                    return new I2L();
                case INSTRUCTION_OPCODE_I2F:
                    return new I2F();
                case INSTRUCTION_OPCODE_I2D:
                    return new I2D();
                case INSTRUCTION_OPCODE_L2I:
                    return new L2I();
                case INSTRUCTION_OPCODE_L2F:
                    return new L2F();
                case INSTRUCTION_OPCODE_L2D:
                    return new L2D();
                case INSTRUCTION_OPCODE_F2I:
                    return new F2I();
                case INSTRUCTION_OPCODE_F2L:
                    return new F2L();
                case INSTRUCTION_OPCODE_F2D:
                    return new F2D();
                case INSTRUCTION_OPCODE_D2I:
                    return new D2I();
                case INSTRUCTION_OPCODE_D2L:
                    return new D2L();
                case INSTRUCTION_OPCODE_D2F:
                    return new D2F();
                case INSTRUCTION_OPCODE_I2B:
                    return new I2B();
                case INSTRUCTION_OPCODE_I2C:
                    return new I2C();
                case INSTRUCTION_OPCODE_I2S:
                    return new I2S();

                // comparision instructions
                case INSTRUCTION_OPCODE_DCMPG:
                    return new DCMPG();
                case INSTRUCTION_OPCODE_DCMPL:
                    return new DCMPL();
                case INSTRUCTION_OPCODE_FCMPG:
                    return new FCMPG();
                case INSTRUCTION_OPCODE_FCMPL:
                    return new FCMPL();
                case INSTRUCTION_OPCODE_IF_ACMPEQ:
                    IF_ACMPEQ if_acmpeq = new IF_ACMPEQ();
                    if_acmpeq.branch1 = code[index++];
                    if_acmpeq.branch2 = code[index++];
                    return if_acmpeq;
                case INSTRUCTION_OPCODE_IF_ACMPNE:
                    IF_ACMPNE if_acmpne = new IF_ACMPNE();
                    if_acmpne.branch1 = code[index++];
                    if_acmpne.branch2 = code[index++];
                    return if_acmpne;
                case INSTRUCTION_OPCODE_IF_ICMPEQ:
                    IF_ICMPEQ if_icmpeq = new IF_ICMPEQ();
                    if_icmpeq.branch1 = code[index++];
                    if_icmpeq.branch2 = code[index++];
                    return if_icmpeq;
                case INSTRUCTION_OPCODE_IF_ICMPGE:
                    IF_ICMPGE if_icmpge = new IF_ICMPGE();
                    if_icmpge.branch1 = code[index++];
                    if_icmpge.branch2 = code[index++];
                    return if_icmpge;
                case INSTRUCTION_OPCODE_IF_ICMPGT:
                    IF_ICMPGT if_icmpgt = new IF_ICMPGT();
                    if_icmpgt.branch1 = code[index++];
                    if_icmpgt.branch2 = code[index++];
                    return if_icmpgt;
                case INSTRUCTION_OPCODE_IF_ICMPLE:
                    IF_ICMPLE if_icmple = new IF_ICMPLE();
                    if_icmple.branch1 = code[index++];
                    if_icmple.branch2 = code[index++];
                    return if_icmple;
                case INSTRUCTION_OPCODE_IF_ICMPLT:
                    IF_ICMPLT if_icmplt = new IF_ICMPLT();
                    if_icmplt.branch1 = code[index++];
                    if_icmplt.branch2 = code[index++];
                    return if_icmplt;
                case INSTRUCTION_OPCODE_IF_ICMPNE:
                    IF_ICMPNE if_icmpne = new IF_ICMPNE();
                    if_icmpne.branch1 = code[index++];
                    if_icmpne.branch2 = code[index++];
                    return if_icmpne;
                case INSTRUCTION_OPCODE_IFEQ:
                    IFEQ ifeq = new IFEQ();
                    ifeq.branch1 = code[index++];
                    ifeq.branch2 = code[index++];
                    return ifeq;
                case INSTRUCTION_OPCODE_IFGE:
                    IFGE ifge = new IFGE();
                    ifge.branch1 = code[index++];
                    ifge.branch2 = code[index++];
                    return ifge;
                case INSTRUCTION_OPCODE_IFGT:
                    IFGT ifgt = new IFGT();
                    ifgt.branch1 = code[index++];
                    ifgt.branch2 = code[index++];
                    return ifgt;
                case INSTRUCTION_OPCODE_IFLE:
                    IFLE ifle = new IFLE();
                    ifle.branch1 = code[index++];
                    ifle.branch2 = code[index++];
                    return ifle;
                case INSTRUCTION_OPCODE_IFLT:
                    IFLT iflt = new IFLT();
                    iflt.branch1 = code[index++];
                    iflt.branch2 = code[index++];
                    return iflt;
                case INSTRUCTION_OPCODE_IFNE:
                    IFNE ifne = new IFNE();
                    ifne.branch1 = code[index++];
                    ifne.branch2 = code[index++];
                    return ifne;
                case INSTRUCTION_OPCODE_LCMP:
                    return new LCMP();

                // control instructions
                case INSTRUCTION_OPCODE_ARETURN:
                    return new ARETURN();
                case INSTRUCTION_OPCODE_DRETURN:
                    return new DRETURN();
                case INSTRUCTION_OPCODE_FRETURN:
                    return new FRETURN();
                case INSTRUCTION_OPCODE_IRETURN:
                    return new IRETURN();
                case INSTRUCTION_OPCODE_LRETURN:
                    return new LRETURN();
                case INSTRUCTION_OPCODE_RETURN:
                    return new RETURN();
                case INSTRUCTION_OPCODE_GOTO:
                    GOTO go_to = new GOTO();
                    go_to.branch1 = code[index++];
                    go_to.branch2 = code[index++];
                    return go_to;
                case INSTRUCTION_OPCODE_JSR:
                    return new JSR();
                case INSTRUCTION_OPCODE_RET:
                    return new RET();
                case INSTRUCTION_OPCODE_LOOKUPSWITCH:
                    LOOKUPSWITCH lookupswitch = new LOOKUPSWITCH();
                    return lookupswitch;
                case INSTRUCTION_OPCODE_TABLESWITCH:
                    TABLESWITCH tableswitch = new TABLESWITCH();
                    return tableswitch;

                // reference instructions
                case INSTRUCTION_OPCODE_NEWARRAY:
                    NEWARRAY newarray = new NEWARRAY();
                    newarray.atype = code[index++];
                    return  newarray;
                case INSTRUCTION_OPCODE_ANEWARRAY:
                    ANEWARRAY anewarray = new ANEWARRAY();
                    anewarray.index1 = code[index++];
                    anewarray.index2 = code[index++];
                    return  anewarray;
                case INSTRUCTION_OPCODE_ARRAYLENGTH:
                    return new ARRAYLENGTH();
                case INSTRUCTION_OPCODE_INVOKEVIRTUAL:
                    INVOKEVIRTUAL invokevirtual = new INVOKEVIRTUAL();
                    invokevirtual.index1 = code[index++];
                    invokevirtual.index2 = code[index++];
                    return  invokevirtual;
                case INSTRUCTION_OPCODE_INVOKESPECIAL:
                    INVOKESPECIAL invokespecial = new INVOKESPECIAL();
                    invokespecial.index1 = code[index++];
                    invokespecial.index2 = code[index++];
                    return  invokespecial;
                case INSTRUCTION_OPCODE_INVOKESTATIC:
                    INVOKESTATIC invokestatic = new INVOKESTATIC();
                    invokestatic.index1 = code[index++];
                    invokestatic.index2 = code[index++];
                    return  invokestatic;
                case INSTRUCTION_OPCODE_INVOKEINTERFACE:
                    INVOKEINTERFACE invokeinterface = new INVOKEINTERFACE();
                    invokeinterface.index1 = code[index++];
                    invokeinterface.index2 = code[index++];
                    invokeinterface.count = code[index++];
                    return  invokeinterface;
                case INSTRUCTION_OPCODE_INVOKEDYNAMIC:
                    INVOKEDYNAMIC invokedynamic = new INVOKEDYNAMIC();
                    invokedynamic.index1 = code[index++];
                    invokedynamic.index2 = code[index++];
                    return  invokedynamic;
                case INSTRUCTION_OPCODE_MONITORENTER:
                    return new MONITORENTER();
                case INSTRUCTION_OPCODE_MONITOREXIT:
                    return new MONITOREXIT();
                case INSTRUCTION_OPCODE_GETSTATIC:
                    GETSTATIC getstatic = new GETSTATIC();
                    getstatic.index1 = code[index++];
                    getstatic.index2 = code[index++];
                    return  getstatic;
                case INSTRUCTION_OPCODE_PUTSTATIC:
                    PUTSTATIC putstatic = new PUTSTATIC();
                    putstatic.index1 = code[index++];
                    putstatic.index2 = code[index++];
                    return  putstatic;
                case INSTRUCTION_OPCODE_GETFIELD:
                    GETFIELD getfield = new GETFIELD();
                    getfield.index1 = code[index++];
                    getfield.index2 = code[index++];
                    return  getfield;
                case INSTRUCTION_OPCODE_PUTFIELD:
                    PUTFIELD putfield = new PUTFIELD();
                    putfield.index1 = code[index++];
                    putfield.index2 = code[index++];
                    return  putfield;
                case INSTRUCTION_OPCODE_NEW:
                    NEW newInstruction = new NEW();
                    newInstruction.index1 = code[index++];
                    newInstruction.index2 = code[index++];
                    return  newInstruction;
                case INSTRUCTION_OPCODE_CHECKCAST:
                    return new CHECKCAST();
                case INSTRUCTION_OPCODE_INSTANCEOF:
                    INSTANCEOF instanceofInstruction = new INSTANCEOF();
                    instanceofInstruction.index1 = code[index++];
                    instanceofInstruction.index2 = code[index++];
                    return  instanceofInstruction;
                case INSTRUCTION_OPCODE_ATHROW:
                    return new ATHROW();

                // extended instructions
                case INSTRUCTION_OPCODE_GOTO_W:
                    GOTO_W gotow = new GOTO_W();
                    gotow.branch1 = code[index++];
                    gotow.branch2 = code[index++];
                    gotow.branch3 = code[index++];
                    gotow.branch4 = code[index++];
                    return  gotow;
                case INSTRUCTION_OPCODE_IFNONNULL:
                    IFNONNULL ifnonnull = new IFNONNULL();
                    ifnonnull.branch1 = code[index++];
                    ifnonnull.branch2 = code[index++];
                    return  ifnonnull;
                case INSTRUCTION_OPCODE_IFNULL:
                    IFNULL ifnull = new IFNULL();
                    ifnull.branch1 = code[index++];
                    ifnull.branch2 = code[index++];
                    return  ifnull;
                case INSTRUCTION_OPCODE_JSR_W:
                    JSR_W jsrw = new JSR_W();
                    jsrw.branch1 = code[index++];
                    jsrw.branch2 = code[index++];
                    jsrw.branch3 = code[index++];
                    jsrw.branch4 = code[index++];
                    return  jsrw;
                case INSTRUCTION_OPCODE_MULTIANEWARRAY:
                    MULTIANEWARRAY multianewarray = new MULTIANEWARRAY();
                    multianewarray.index1 = code[index++];
                    multianewarray.index2 = code[index++];
                    multianewarray.dimensions = code[index++];
                    return  multianewarray;
                case INSTRUCTION_OPCODE_WIDE:
                    return parseWIDE();

                // reserved instructions
                case INSTRUCTION_OPCODE_BREAKPOINT:
                    return new BREAKPOINT();
                case INSTRUCTION_OPCODE_IMPDEP1:
                    return new IMPDEP1();
                case INSTRUCTION_OPCODE_IMPDEP2:
                    return new IMPDEP2();
            }

        throw new IllegalStateException("");
    }

    private Instruction parseWIDE(){
        WIDE wide = new WIDE();
        wide.nopcode = code[index++];

        switch (wide.nopcode) {
            case INSTRUCTION_OPCODE_ILOAD:
            case INSTRUCTION_OPCODE_LLOAD:
            case INSTRUCTION_OPCODE_FLOAD:
            case INSTRUCTION_OPCODE_DLOAD:
            case INSTRUCTION_OPCODE_ALOAD:
            case INSTRUCTION_OPCODE_ILOAD_0:
            case INSTRUCTION_OPCODE_ILOAD_1:
            case INSTRUCTION_OPCODE_ILOAD_2:
            case INSTRUCTION_OPCODE_ILOAD_3:
            case INSTRUCTION_OPCODE_LLOAD_0:
            case INSTRUCTION_OPCODE_LLOAD_1:
            case INSTRUCTION_OPCODE_LLOAD_2:
            case INSTRUCTION_OPCODE_LLOAD_3:
            case INSTRUCTION_OPCODE_FLOAD_0:
            case INSTRUCTION_OPCODE_FLOAD_1:
            case INSTRUCTION_OPCODE_FLOAD_2:
            case INSTRUCTION_OPCODE_FLOAD_3:
            case INSTRUCTION_OPCODE_DLOAD_0:
            case INSTRUCTION_OPCODE_DLOAD_1:
            case INSTRUCTION_OPCODE_DLOAD_2:
            case INSTRUCTION_OPCODE_DLOAD_3:
            case INSTRUCTION_OPCODE_ALOAD_0:
            case INSTRUCTION_OPCODE_ALOAD_1:
            case INSTRUCTION_OPCODE_ALOAD_2:
            case INSTRUCTION_OPCODE_ALOAD_3:

            case INSTRUCTION_OPCODE_ISTORE:
            case INSTRUCTION_OPCODE_LSTORE:
            case INSTRUCTION_OPCODE_FSTORE:
            case INSTRUCTION_OPCODE_DSTORE:
            case INSTRUCTION_OPCODE_ASTORE:
            case INSTRUCTION_OPCODE_ISTORE_0:
            case INSTRUCTION_OPCODE_ISTORE_1:
            case INSTRUCTION_OPCODE_ISTORE_2:
            case INSTRUCTION_OPCODE_ISTORE_3:
            case INSTRUCTION_OPCODE_LSTORE_0:
            case INSTRUCTION_OPCODE_LSTORE_1:
            case INSTRUCTION_OPCODE_LSTORE_2:
            case INSTRUCTION_OPCODE_LSTORE_3:
            case INSTRUCTION_OPCODE_FSTORE_0:
            case INSTRUCTION_OPCODE_FSTORE_1:
            case INSTRUCTION_OPCODE_FSTORE_2:
            case INSTRUCTION_OPCODE_FSTORE_3:
            case INSTRUCTION_OPCODE_DSTORE_0:
            case INSTRUCTION_OPCODE_DSTORE_1:
            case INSTRUCTION_OPCODE_DSTORE_2:
            case INSTRUCTION_OPCODE_DSTORE_3:
            case INSTRUCTION_OPCODE_ASTORE_0:
            case INSTRUCTION_OPCODE_ASTORE_1:
            case INSTRUCTION_OPCODE_ASTORE_2:
            case INSTRUCTION_OPCODE_ASTORE_3:
            case INSTRUCTION_OPCODE_RET:
                wide.index1 = code[index++];
                wide.index2 = code[index++];
                return wide;
            case INSTRUCTION_OPCODE_IINC:
                wide.index1 = code[index++];
                wide.index2 = code[index++];
                wide.const1 = code[index++];
                wide.const2 = code[index++];
                return wide;
        }

        throw new IllegalStateException("");
    }

    private boolean hasNext(){
        return index < code.length;
    }
}
