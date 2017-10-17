package smalljvm.interpreter;

import smalljvm.classfile.ConstantInfo;
import smalljvm.classfile.Instruction;
import smalljvm.classfile.constant.DoubleConstant;
import smalljvm.classfile.constant.FloatConstant;
import smalljvm.classfile.constant.IntegerConstant;
import smalljvm.classfile.constant.LongConstant;
import smalljvm.classfile.instruction.comparison.*;
import smalljvm.classfile.instruction.constant.*;
import smalljvm.classfile.instruction.control.*;
import smalljvm.classfile.instruction.extended.*;
import smalljvm.classfile.instruction.load.*;
import smalljvm.classfile.instruction.math.*;
import smalljvm.classfile.instruction.reference.*;
import smalljvm.classfile.instruction.store.*;
import smalljvm.rtda.*;
import smalljvm.rtda.Thread;

import static smalljvm.classfile.Env.*;

public class DefaultInterpreter extends Interpreter{
    @Override
    public void execute(Instruction instruction, Thread thread, Heap heap, MethodArea area) {
        Frame cur = thread.curFrame();
        KMethod method = cur.method();
        OperandStack os = cur.os();
        LocalVariableTable lvt = cur.lvt();
        KClass clazz = cur.clazz();
        ConstantInfo[] cp = clazz.getConstantPool();
        LocalVariableTable slots = clazz.getStaticSlots();

        switch (instruction.opcode()) {
            // constant instructions
            case INSTRUCTION_OPCODE_NOP:
                // do nothing;
                return;
            case INSTRUCTION_OPCODE_ACONST_NULL:
                os.pushRef(0);
                return;
            case INSTRUCTION_OPCODE_ICONST_M1:
                os.pushInt(-1);
                return;
            case INSTRUCTION_OPCODE_ICONST_0:
                os.pushInt(0);
                return;
            case INSTRUCTION_OPCODE_ICONST_1:
                os.pushInt(1);
                return;
            case INSTRUCTION_OPCODE_ICONST_2:
                os.pushInt(2);
                return;
            case INSTRUCTION_OPCODE_ICONST_3:
                os.pushInt(3);
                return;
            case INSTRUCTION_OPCODE_ICONST_4:
                os.pushInt(4);
                return;
            case INSTRUCTION_OPCODE_ICONST_5:
                os.pushInt(5);
                return;
            case INSTRUCTION_OPCODE_LCONST_0:
                os.pushLong(0L);
                return;
            case INSTRUCTION_OPCODE_LCONST_1:
                os.pushLong(1L);
                return;
            case INSTRUCTION_OPCODE_FCONST_0:
                os.pushFloat(0.0F);
                return;
            case INSTRUCTION_OPCODE_FCONST_1:
                os.pushFloat(1.0F);
                return;
            case INSTRUCTION_OPCODE_FCONST_2:
                os.pushFloat(2.0F);
                return;
            case INSTRUCTION_OPCODE_DCONST_0:
                os.pushDouble(0.0);
                return;
            case INSTRUCTION_OPCODE_DCONST_1:
                os.pushDouble(1.0);
                return;
            case INSTRUCTION_OPCODE_BIPUSH:
                BIPUSH bipush = (BIPUSH)instruction;
                os.pushInt((int)bipush.value());
                return;
            case INSTRUCTION_OPCODE_SIPUSH:
                SIPUSH sipush = (SIPUSH)instruction;
                os.pushInt((int)sipush.value());
                return;
            case INSTRUCTION_OPCODE_LDC:
                LDC ldc = (LDC)instruction;
                byte ldc_index = ldc.index();
                ConstantInfo ldc_constant = cp[ldc_index];
                if(ConstantInfo.isInteger(ldc_constant)){
                    IntegerConstant ldc_constant_integer = (IntegerConstant)ldc_constant;
                    os.pushInt(ldc_constant_integer.value());
                }
                else if(ConstantInfo.isFloat(ldc_constant)){
                    FloatConstant ldc_constant_float = (FloatConstant)ldc_constant;
                    os.pushFloat(ldc_constant_float.value());
                }
                else if(ConstantInfo.isString(ldc_constant)){
                    throw new IllegalStateException("Unsupported");
                }
                else if(ConstantInfo.isClass(ldc_constant)){
                    throw new IllegalStateException("Unsupported");
                }
                else{
                    throw new IllegalStateException("Unsupported");
                }
                return;
            case INSTRUCTION_OPCODE_LDC_W:
                LDC_W ldc_w = (LDC_W)instruction;
                short ldc_w_index = ldc_w.index();
                ConstantInfo ldc_w_constant = cp[ldc_w_index];
                if(ConstantInfo.isInteger(ldc_w_constant)){
                    IntegerConstant ldc_w_constant_integer = (IntegerConstant)ldc_w_constant;
                    os.pushInt(ldc_w_constant_integer.value());
                }
                else if(ConstantInfo.isLong(ldc_w_constant)){
                    FloatConstant ldc_w_constant_float = (FloatConstant)ldc_w_constant;
                    os.pushFloat(ldc_w_constant_float.value());
                }
                else if(ConstantInfo.isString(ldc_w_constant)){
                    throw new IllegalStateException("Unsupported");
                }
                else if(ConstantInfo.isClass(ldc_w_constant)){
                    throw new IllegalStateException("Unsupported");
                }
                else{
                    throw new IllegalStateException("Unsupported");
                }
                return;
            case INSTRUCTION_OPCODE_LDC2_W:
                LDC2_W ldc2_w = (LDC2_W)instruction;
                short ldc2_w_index = ldc2_w.index();
                ConstantInfo ldc2_w_constant = cp[ldc2_w_index];
                if(ConstantInfo.isLong(ldc2_w_constant)){
                    LongConstant ldc2_w_constant_long = (LongConstant)ldc2_w_constant;
                    os.pushLong(ldc2_w_constant_long.value());
                }
                else if(ConstantInfo.isDouble(ldc2_w_constant)){
                    DoubleConstant ldc2_w_constant_double = (DoubleConstant)ldc2_w_constant;
                    os.pushDouble(ldc2_w_constant_double.value());
                }
                else{
                    throw new IllegalStateException("Unsupported");
                }
                return;

            // math11 instructions
            case INSTRUCTION_OPCODE_DADD:
                double dadd_value2 = os.popDouble();
                double dadd_value1 = os.popDouble();
                os.pushDouble(dadd_value1 + dadd_value2);
                return;
            case INSTRUCTION_OPCODE_DSUB:
                double dsub_value2 = os.popDouble();
                double dsub_value1 = os.popDouble();
                os.pushDouble(dsub_value1 - dsub_value2);
                return;
            case INSTRUCTION_OPCODE_DMUL:
                double dmul_value2 = os.popDouble();
                double dmul_value1 = os.popDouble();
                os.pushDouble(dmul_value1 * dmul_value2);
                return;
            case INSTRUCTION_OPCODE_DDIV:
                double ddiv_value2 = os.popDouble();
                double ddiv_value1 = os.popDouble();
                os.pushDouble(ddiv_value1 / ddiv_value2);
                return;
            case INSTRUCTION_OPCODE_DREM:
                double drem_value2 = os.popDouble();
                double drem_value1 = os.popDouble();
                os.pushDouble(drem_value1 % drem_value2);
                return;
            case INSTRUCTION_OPCODE_DNEG:
                os.pushDouble(0 - os.popDouble());
                return;
            case INSTRUCTION_OPCODE_FADD:
                float fadd_value2 = os.popFloat();
                float fadd_value1 = os.popFloat();
                os.pushFloat(fadd_value1 + fadd_value2);
                return;
            case INSTRUCTION_OPCODE_FSUB:
                float fsub_value2 = os.popFloat();
                float fsub_value1 = os.popFloat();
                os.pushFloat(fsub_value1 - fsub_value2);
                return;
            case INSTRUCTION_OPCODE_FMUL:
                float fmul_value2 = os.popFloat();
                float fmul_value1 = os.popFloat();
                os.pushFloat(fmul_value1 * fmul_value2);
                return;
            case INSTRUCTION_OPCODE_FDIV:
                float fdiv_value2 = os.popFloat();
                float fdiv_value1 = os.popFloat();
                os.pushFloat(fdiv_value1 / fdiv_value2);
                return;
            case INSTRUCTION_OPCODE_FREM:
                float frem_value2 = os.popFloat();
                float frem_value1 = os.popFloat();
                os.pushFloat(frem_value1 % frem_value2);
                return;
            case INSTRUCTION_OPCODE_FNEG:
                os.pushFloat(0 - os.popFloat());
                return;
            case INSTRUCTION_OPCODE_IADD:
                int iadd_value2 = os.popInt();
                int iadd_value1 = os.popInt();
                os.pushInt(iadd_value1 + iadd_value2);
                return;
            case INSTRUCTION_OPCODE_ISUB:
                int isub_value2 = os.popInt();
                int isub_value1 = os.popInt();
                os.pushInt(isub_value1 - isub_value2);
                return;
            case INSTRUCTION_OPCODE_IMUL:
                int imul_value2 = os.popInt();
                int imul_value1 = os.popInt();
                os.pushInt(imul_value1 * imul_value2);
                return;
            case INSTRUCTION_OPCODE_IDIV:
                int idiv_value2 = os.popInt();
                int idiv_value1 = os.popInt();
                os.pushInt(idiv_value1 / idiv_value2);
                return;
            case INSTRUCTION_OPCODE_IREM:
                int irem_value2 = os.popInt();
                int irem_value1 = os.popInt();
                os.pushInt(irem_value1 % irem_value2);
                return;
            case INSTRUCTION_OPCODE_INEG:
                os.pushInt(0 - os.popInt());
                return;
            case INSTRUCTION_OPCODE_IAND:
                int iand_value2 = os.popInt();
                int iand_value1 = os.popInt();
                os.pushInt(iand_value1 & iand_value2);
                return;
            case INSTRUCTION_OPCODE_IOR:
                int ior_value2 = os.popInt();
                int ior_value1 = os.popInt();
                os.pushInt(ior_value1 | ior_value2);
                return;
            case INSTRUCTION_OPCODE_IXOR:
                int ixor_value2 = os.popInt();
                int ixor_value1 = os.popInt();
                os.pushInt(ixor_value1 ^ ixor_value2);
                return;
            case INSTRUCTION_OPCODE_ISHR:
                int ishr_value2 = os.popInt();
                int ishr_value1 = os.popInt();
                os.pushInt(ishr_value1 >> (ishr_value2 & 0x1F));
                return;
            case INSTRUCTION_OPCODE_IUSHR:
                int iushr_value2 = os.popInt();
                int iushr_value1 = os.popInt();
                os.pushInt(iushr_value1 >>> (iushr_value2 & 0x1F));
                return;
            case INSTRUCTION_OPCODE_ISHL:
                int ishl_value2 = os.popInt();
                int ishl_value1 = os.popInt();
                os.pushInt(ishl_value1 << (ishl_value2 & 0x1F));
                return;
            case INSTRUCTION_OPCODE_IINC:
                IINC iinc = (IINC)instruction;
                byte iinc_index = iinc.index;
                byte iinc_const = iinc.constant;
                lvt.setInt(iinc_index, lvt.getInt(iinc_index) + (int)iinc_const);
                return;
            case INSTRUCTION_OPCODE_LADD:
                long ladd_value2 = os.popLong();
                long ladd_value1 = os.popLong();
                os.pushLong(ladd_value1 + ladd_value2);
                return;
            case INSTRUCTION_OPCODE_LSUB:
                long lsub_value2 = os.popLong();
                long lsub_value1 = os.popLong();
                os.pushLong(lsub_value1 - lsub_value2);
                return;
            case INSTRUCTION_OPCODE_LMUL:
                long lmul_value2 = os.popLong();
                long lmul_value1 = os.popLong();
                os.pushLong(lmul_value1 * lmul_value2);
                return;
            case INSTRUCTION_OPCODE_LDIV:
                long ldiv_value2 = os.popLong();
                long ldiv_value1 = os.popLong();
                os.pushLong(ldiv_value1 / ldiv_value2);
                return;
            case INSTRUCTION_OPCODE_LREM:
                long lrem_value2 = os.popLong();
                long lrem_value1 = os.popLong();
                os.pushLong(lrem_value1 % lrem_value2);
                return;
            case INSTRUCTION_OPCODE_LNEG:
                os.pushLong(0 - os.popLong());
                return;
            case INSTRUCTION_OPCODE_LAND:
                long land_value2 = os.popLong();
                long land_value1 = os.popLong();
                os.pushLong(land_value1 & land_value2);
                return;
            case INSTRUCTION_OPCODE_LOR:
                long lor_value2 = os.popLong();
                long lor_value1 = os.popLong();
                os.pushLong(lor_value1 | lor_value2);
                return;
            case INSTRUCTION_OPCODE_LXOR:
                long lxor_value2 = os.popLong();
                long lxor_value1 = os.popLong();
                os.pushLong(lxor_value1 ^ lxor_value2);
                return;
            case INSTRUCTION_OPCODE_LSHR:
                int lshr_value2 = os.popInt();
                long lshr_value1 = os.popLong();
                os.pushLong(lshr_value1 >> (lshr_value2 & 0x1F));
                return;
            case INSTRUCTION_OPCODE_LUSHR:
                int lushr_value2 = os.popInt();
                long lushr_value1 = os.popLong();
                os.pushLong(lushr_value1 >>> (lushr_value2 & 0x1F));
                return;
            case INSTRUCTION_OPCODE_LSHL:
                int lshl_value2 = os.popInt();
                long lshl_value1 = os.popLong();
                os.pushLong(lshl_value1 << (lshl_value2 & 0x1F));
                return;

            // load instructions
            case INSTRUCTION_OPCODE_ALOAD:
                ALOAD aload = (ALOAD)instruction;
                byte aload_index = aload.index;
                int aload_value = lvt.getRef(aload_index);
                os.pushRef(aload_value);
                return;
            case INSTRUCTION_OPCODE_ALOAD_0:
                int aload_0_value = lvt.getRef(0);
                os.pushRef(aload_0_value);
                return;
            case INSTRUCTION_OPCODE_ALOAD_1:
                int aload_1_value = lvt.getRef(1);
                os.pushRef(aload_1_value);
                return;
            case INSTRUCTION_OPCODE_ALOAD_2:
                int aload_2_value = lvt.getRef(2);
                os.pushRef(aload_2_value);
                return;
            case INSTRUCTION_OPCODE_ALOAD_3:
                int aload_3_value = lvt.getRef(3);
                os.pushRef(aload_3_value);
                return;
            case INSTRUCTION_OPCODE_DLOAD:
                DLOAD dload = (DLOAD)instruction;
                byte dload_index = dload.index;
                double dload_value = lvt.getDouble(dload_index);
                os.pushDouble(dload_value);
                return;
            case INSTRUCTION_OPCODE_DLOAD_0:
                double dload_0_value = lvt.getDouble(0);
                os.pushDouble(dload_0_value);
                return;
            case INSTRUCTION_OPCODE_DLOAD_1:
                double dload_1_value = lvt.getDouble(1);
                os.pushDouble(dload_1_value);
                return;
            case INSTRUCTION_OPCODE_DLOAD_2:
                double dload_2_value = lvt.getDouble(2);
                os.pushDouble(dload_2_value);
                return;
            case INSTRUCTION_OPCODE_DLOAD_3:
                double dload_3_value = lvt.getDouble(3);
                os.pushDouble(dload_3_value);
                return;
            case INSTRUCTION_OPCODE_FLOAD:
                FLOAD fload = (FLOAD)instruction;
                byte fload_index = fload.index;
                float fload_value = lvt.getFloat(fload_index);
                os.pushFloat(fload_value);
                return;
            case INSTRUCTION_OPCODE_FLOAD_0:
                float fload_0_value = lvt.getFloat(0);
                os.pushFloat(fload_0_value);
                return;
            case INSTRUCTION_OPCODE_FLOAD_1:
                float fload_1_value = lvt.getFloat(1);
                os.pushFloat(fload_1_value);
                return;
            case INSTRUCTION_OPCODE_FLOAD_2:
                float fload_2_value = lvt.getFloat(2);
                os.pushFloat(fload_2_value);
                return;
            case INSTRUCTION_OPCODE_FLOAD_3:
                float fload_3_value = lvt.getFloat(3);
                os.pushFloat(fload_3_value);
                return;
            case INSTRUCTION_OPCODE_ILOAD:
                ILOAD iload = (ILOAD)instruction;
                byte iload_index = iload.index;
                int iload_value = lvt.getInt(iload_index);
                os.pushInt(iload_value);
                return;
            case INSTRUCTION_OPCODE_ILOAD_0:
                int iload_0_value = lvt.getInt(0);
                os.pushInt(iload_0_value);
                return;
            case INSTRUCTION_OPCODE_ILOAD_1:
                int iload_1_value = lvt.getInt(1);
                os.pushInt(iload_1_value);
                return;
            case INSTRUCTION_OPCODE_ILOAD_2:
                int iload_2_value = lvt.getInt(2);
                os.pushInt(iload_2_value);
                return;
            case INSTRUCTION_OPCODE_ILOAD_3:
                int iload_3_value = lvt.getInt(3);
                os.pushInt(iload_3_value);
                return;
            case INSTRUCTION_OPCODE_LLOAD:
                LLOAD lload = (LLOAD)instruction;
                byte lload_index = lload.index;
                long lload_value = lvt.getLong(lload_index);
                os.pushLong(lload_value);
                return;
            case INSTRUCTION_OPCODE_LLOAD_0:
                long lload_0_value = lvt.getLong(0);
                os.pushLong(lload_0_value);
                return;
            case INSTRUCTION_OPCODE_LLOAD_1:
                long lload_1_value = lvt.getLong(1);
                os.pushLong(lload_1_value);
                return;
            case INSTRUCTION_OPCODE_LLOAD_2:
                long lload_2_value = lvt.getLong(2);
                os.pushLong(lload_2_value);
                return;
            case INSTRUCTION_OPCODE_LLOAD_3:
                long lload_3_value = lvt.getLong(3);
                os.pushLong(lload_3_value);
                return;
            case INSTRUCTION_OPCODE_LALOAD:
                throw new IllegalStateException("Unsupported");
            case INSTRUCTION_OPCODE_SALOAD:
                throw new IllegalStateException("Unsupported");
            case INSTRUCTION_OPCODE_AALOAD:
                throw new IllegalStateException("Unsupported");
            case INSTRUCTION_OPCODE_IALOAD:
                throw new IllegalStateException("Unsupported");
            case INSTRUCTION_OPCODE_FALOAD:
                throw new IllegalStateException("Unsupported");
            case INSTRUCTION_OPCODE_DALOAD:
                throw new IllegalStateException("Unsupported");
            case INSTRUCTION_OPCODE_BALOAD:
                throw new IllegalStateException("Unsupported");
            case INSTRUCTION_OPCODE_CALOAD:
                throw new IllegalStateException("Unsupported");

                // store instructions
            case INSTRUCTION_OPCODE_ASTORE:
                ASTORE astore = (ASTORE)instruction;
                byte astore_index = astore.index;
                int astore_value = os.popRef();
                lvt.setRef(astore_index, astore_value);
                return;
            case INSTRUCTION_OPCODE_ASTORE_0:
                int astore_0_value = os.popRef();
                lvt.setRef(0, astore_0_value);
                return;
            case INSTRUCTION_OPCODE_ASTORE_1:
                int astore_1_value = os.popRef();
                lvt.setRef(1, astore_1_value);
                return;
            case INSTRUCTION_OPCODE_ASTORE_2:
                int astore_2_value = os.popRef();
                lvt.setRef(2, astore_2_value);
                return;
            case INSTRUCTION_OPCODE_ASTORE_3:
                int astore_3_value = os.popRef();
                lvt.setRef(3, astore_3_value);
                return;
            case INSTRUCTION_OPCODE_DSTORE:
                DSTORE dstore = (DSTORE)instruction;
                byte dstore_index = dstore.index;
                double dstore_value = os.popDouble();
                lvt.setDouble(dstore_index, dstore_value);
                return;
            case INSTRUCTION_OPCODE_DSTORE_0:
                double dstore_0_value = os.popDouble();
                lvt.setDouble(0, dstore_0_value);
                return;
            case INSTRUCTION_OPCODE_DSTORE_1:
                double dstore_1_value = os.popDouble();
                lvt.setDouble(1, dstore_1_value);
                return;
            case INSTRUCTION_OPCODE_DSTORE_2:
                double dstore_2_value = os.popDouble();
                lvt.setDouble(2, dstore_2_value);
                return;
            case INSTRUCTION_OPCODE_DSTORE_3:
                double dstore_3_value = os.popDouble();
                lvt.setDouble(3, dstore_3_value);
                return;
            case INSTRUCTION_OPCODE_FSTORE:
                FSTORE fstore = (FSTORE)instruction;
                byte fstore_index = fstore.index;
                float fstore_value = os.popFloat();
                lvt.setFloat(fstore_index, fstore_value);
                return;
            case INSTRUCTION_OPCODE_FSTORE_0:
                float fstore_0_value = os.popFloat();
                lvt.setFloat(0, fstore_0_value);
                return;
            case INSTRUCTION_OPCODE_FSTORE_1:
                float fstore_1_value = os.popFloat();
                lvt.setFloat(1, fstore_1_value);
                return;
            case INSTRUCTION_OPCODE_FSTORE_2:
                float fstore_2_value = os.popFloat();
                lvt.setFloat(2, fstore_2_value);
                return;
            case INSTRUCTION_OPCODE_FSTORE_3:
                float fstore_3_value = os.popFloat();
                lvt.setFloat(3, fstore_3_value);
                return;
            case INSTRUCTION_OPCODE_ISTORE:
                ISTORE istore = (ISTORE)instruction;
                byte istore_index = istore.index;
                int istore_value = os.popInt();
                lvt.setInt(istore_index, istore_value);
                return;
            case INSTRUCTION_OPCODE_ISTORE_0:
                int istore_0_value = os.popInt();
                lvt.setInt(0, istore_0_value);
                return;
            case INSTRUCTION_OPCODE_ISTORE_1:
                int istore_1_value = os.popInt();
                lvt.setInt(1, istore_1_value);
                return;
            case INSTRUCTION_OPCODE_ISTORE_2:
                int istore_2_value = os.popInt();
                lvt.setInt(2, istore_2_value);
                return;
            case INSTRUCTION_OPCODE_ISTORE_3:
                int istore_3_value = os.popInt();
                lvt.setInt(3, istore_3_value);
                return;
            case INSTRUCTION_OPCODE_LSTORE:
                LSTORE lstore = (LSTORE)instruction;
                byte lstore_index = lstore.index;
                long lstore_value = os.popLong();
                lvt.setLong(lstore_index, lstore_value);
                return;
            case INSTRUCTION_OPCODE_LSTORE_0:
                long lstore_0_value = os.popLong();
                lvt.setLong(0, lstore_0_value);
                return;
            case INSTRUCTION_OPCODE_LSTORE_1:
                long lstore_1_value = os.popLong();
                lvt.setLong(1, lstore_1_value);
                return;
            case INSTRUCTION_OPCODE_LSTORE_2:
                long lstore_2_value = os.popLong();
                lvt.setLong(2, lstore_2_value);
                return;
            case INSTRUCTION_OPCODE_LSTORE_3:
                long lstore_3_value = os.popLong();
                lvt.setLong(3, lstore_3_value);
                return;
            case INSTRUCTION_OPCODE_AASTORE:
                int aastore_value = os.popRef();
                int aastore_index = os.popInt();
                int aastore_ref = os.popRef();
                return;
            case INSTRUCTION_OPCODE_BASTORE:
                throw new IllegalStateException("Unsupported");
            case INSTRUCTION_OPCODE_CASTORE:
                throw new IllegalStateException("Unsupported");
            case INSTRUCTION_OPCODE_DASTORE:
                throw new IllegalStateException("Unsupported");
            case INSTRUCTION_OPCODE_FASTORE:
                throw new IllegalStateException("Unsupported");
            case INSTRUCTION_OPCODE_IASTORE:
                throw new IllegalStateException("Unsupported");
            case INSTRUCTION_OPCODE_LASTORE:
                throw new IllegalStateException("Unsupported");
            case INSTRUCTION_OPCODE_SASTORE:
                throw new IllegalStateException("Unsupported");

                // stack instructions
            case INSTRUCTION_OPCODE_POP:
                os.popInt();
                return;
            case INSTRUCTION_OPCODE_POP2:
                os.popInt();
                os.popInt();
                return;
            case INSTRUCTION_OPCODE_DUP:
                int dup_value = os.popInt();
                os.pushInt(dup_value);
                os.pushInt(dup_value);
                return;
            case INSTRUCTION_OPCODE_DUP_X1:
                int dup_x1_value1 = os.popInt();
                int dup_x1_value2 = os.popInt();
                os.pushInt(dup_x1_value1);
                os.pushInt(dup_x1_value2);
                os.pushInt(dup_x1_value1);
                return;
            case INSTRUCTION_OPCODE_DUP_X2:
                int dup_x2_value1 = os.popInt();
                int dup_x2_value2 = os.popInt();
                int dup_x2_value3 = os.popInt();
                os.pushInt(dup_x2_value1);
                os.pushInt(dup_x2_value3);
                os.pushInt(dup_x2_value2);
                os.pushInt(dup_x2_value1);
                return;
            case INSTRUCTION_OPCODE_DUP2:
                int dup2_value1 = os.popInt();
                int dup2_value2 = os.popInt();
                os.pushInt(dup2_value2);
                os.pushInt(dup2_value1);
                os.pushInt(dup2_value2);
                os.pushInt(dup2_value1);
                return;
            case INSTRUCTION_OPCODE_DUP2_X1:
                int dup2_x1_value1 = os.popInt();
                int dup2_x1_value2 = os.popInt();
                int dup2_x1_value3 = os.popInt();
                os.pushInt(dup2_x1_value2);
                os.pushInt(dup2_x1_value1);
                os.pushInt(dup2_x1_value3);
                os.pushInt(dup2_x1_value2);
                os.pushInt(dup2_x1_value1);
                return;
            case INSTRUCTION_OPCODE_DUP2_X2:
                int dup2_x2_value1 = os.popInt();
                int dup2_x2_value2 = os.popInt();
                int dup2_x2_value3 = os.popInt();
                int dup2_x2_value4 = os.popInt();
                os.pushInt(dup2_x2_value2);
                os.pushInt(dup2_x2_value1);
                os.pushInt(dup2_x2_value4);
                os.pushInt(dup2_x2_value3);
                os.pushInt(dup2_x2_value2);
                os.pushInt(dup2_x2_value1);
                return;
            case INSTRUCTION_OPCODE_SWAP:
                int swap_value1 = os.popInt();
                int swap_value2 = os.popInt();
                os.pushInt(swap_value1);
                os.pushInt(swap_value2);
                return;


            // conversion instructions
            case INSTRUCTION_OPCODE_I2L:
                os.pushLong((long)os.popInt());
                return;
            case INSTRUCTION_OPCODE_I2F:
                os.pushFloat((float)os.popInt());
                return;
            case INSTRUCTION_OPCODE_I2D:
                os.pushDouble((double)os.popInt());
                return;
            case INSTRUCTION_OPCODE_L2I:
                os.pushInt((int)os.popLong());
                return;
            case INSTRUCTION_OPCODE_L2F:
                os.pushFloat((float)os.popLong());
                return;
            case INSTRUCTION_OPCODE_L2D:
                os.pushDouble((double)os.popLong());
                return;
            case INSTRUCTION_OPCODE_F2I:
                os.pushInt((int)os.popFloat());
                return;
            case INSTRUCTION_OPCODE_F2L:
                os.pushLong((long)os.popFloat());
                return;
            case INSTRUCTION_OPCODE_F2D:
                os.pushDouble((double)os.popFloat());
                return;
            case INSTRUCTION_OPCODE_D2I:
                os.pushInt((int)os.popDouble());
                return;
            case INSTRUCTION_OPCODE_D2L:
                os.pushLong((long)os.popDouble());
                return;
            case INSTRUCTION_OPCODE_D2F:
                os.pushFloat((float)os.popDouble());
                return;
            case INSTRUCTION_OPCODE_I2B:
                os.pushInt((byte)os.popInt());
                return;
            case INSTRUCTION_OPCODE_I2C:
                os.pushInt((char)os.popInt());
                return;
            case INSTRUCTION_OPCODE_I2S:
                os.pushInt((short)os.popInt());
                return;

            // comparision instructions
            case INSTRUCTION_OPCODE_DCMPG:
                double dcmpg_value2 = os.popDouble();
                double dcmpg_value1 = os.popDouble();
                if (dcmpg_value1 > dcmpg_value2) {
                    os.pushInt(1);
                }
                else if (dcmpg_value1 == dcmpg_value2) {
                    os.pushInt(0);
                }
                else if (dcmpg_value1 < dcmpg_value2){
                    os.pushInt(-1);
                }
                else {
                    os.pushInt(1);
                }
                return;
            case INSTRUCTION_OPCODE_DCMPL:
                double dcmpl_value2 = os.popDouble();
                double dcmpl_value1 = os.popDouble();
                if (dcmpl_value1 > dcmpl_value2) {
                    os.pushInt(1);
                }
                else if (dcmpl_value1 == dcmpl_value2) {
                    os.pushInt(0);
                }
                else if (dcmpl_value1 < dcmpl_value2){
                    os.pushInt(-1);
                }
                else {
                    os.pushInt(-1);
                }
                return;
            case INSTRUCTION_OPCODE_FCMPG:
                float fcmpg_value2 = os.popFloat();
                float fcmpg_value1 = os.popFloat();
                if (fcmpg_value1 > fcmpg_value2) {
                    os.pushInt(1);
                }
                else if (fcmpg_value1 == fcmpg_value2) {
                    os.pushInt(0);
                }
                else if (fcmpg_value1 < fcmpg_value2){
                    os.pushInt(-1);
                }
                else {
                    os.pushInt(1);
                }
                return;
            case INSTRUCTION_OPCODE_FCMPL:
                float fcmpl_value2 = os.popFloat();
                float fcmpl_value1 = os.popFloat();
                if (fcmpl_value1 > fcmpl_value2) {
                    os.pushInt(1);
                }
                else if (fcmpl_value1 == fcmpl_value2) {
                    os.pushInt(0);
                }
                else if (fcmpl_value1 < fcmpl_value2){
                    os.pushInt(-1);
                }
                else {
                    os.pushInt(-1);
                }
                return;
            case INSTRUCTION_OPCODE_LCMP:
                long lcmp_value2 = os.popLong();
                long lcmp_value1 = os.popLong();
                if (lcmp_value1 > lcmp_value2) {
                    os.pushInt(1);
                }
                else if (lcmp_value1 == lcmp_value2) {
                    os.pushInt(0);
                }
                else {
                    os.pushInt(-1);
                }
                return;
            case INSTRUCTION_OPCODE_IF_ACMPEQ:
                IF_ACMPEQ if_acmpeq = (IF_ACMPEQ)instruction;
                short if_acmpeq_branch = if_acmpeq.branch();
                int if_acmpeq_value2 = os.popRef();
                int if_acmpeq_value1 = os.popRef();
                if(if_acmpeq_value1 == if_acmpeq_value2){
                    int if_acmpeq_pc = thread.getPc() - if_acmpeq.length();
                    int if_acmpeq_pc_next = if_acmpeq_pc + if_acmpeq_branch;
                    thread.setPc(if_acmpeq_pc_next);
                }
                return;
            case INSTRUCTION_OPCODE_IF_ACMPNE:
                IF_ACMPNE if_acmpne = (IF_ACMPNE)instruction;
                short if_acmpne_branch = if_acmpne.branch();
                int if_acmpne_value2 = os.popRef();
                int if_acmpne_value1 = os.popRef();
                if(if_acmpne_value1 != if_acmpne_value2){
                    int if_acmpne_pc = thread.getPc() - if_acmpne.length();
                    int if_acmpne_pc_next = if_acmpne_pc + if_acmpne_branch;
                    thread.setPc(if_acmpne_pc_next);
                }
                return;
            case INSTRUCTION_OPCODE_IF_ICMPEQ:
                IF_ICMPEQ if_icmpeq = (IF_ICMPEQ)instruction;
                short if_icmpeq_branch = if_icmpeq.branch();
                int if_icmpeq_value2 = os.popInt();
                int if_icmpeq_value1 = os.popInt();
                if(if_icmpeq_value1 == if_icmpeq_value2){
                    int if_icmpeq_pc = thread.getPc() - if_icmpeq.length();
                    int if_icmpeq_pc_next = if_icmpeq_pc + if_icmpeq_branch;
                    thread.setPc(if_icmpeq_pc_next);
                }
                return;
            case INSTRUCTION_OPCODE_IF_ICMPNE:
                IF_ICMPNE if_icmpne = (IF_ICMPNE)instruction;
                short if_icmpne_branch = if_icmpne.branch();
                int if_icmpne_value2 = os.popInt();
                int if_icmpne_value1 = os.popInt();
                if(if_icmpne_value1 != if_icmpne_value2){
                    int if_icmpne_pc = thread.getPc() - if_icmpne.length();
                    int if_icmpne_pc_next = if_icmpne_pc + if_icmpne_branch;
                    thread.setPc(if_icmpne_pc_next);
                }
                return;
            case INSTRUCTION_OPCODE_IF_ICMPGE:
                IF_ICMPGE if_icmpge = (IF_ICMPGE)instruction;
                short if_icmpge_branch = if_icmpge.branch();
                int if_icmpge_value2 = os.popInt();
                int if_icmpge_value1 = os.popInt();
                if(if_icmpge_value1 >= if_icmpge_value2){
                    int if_icmpge_pc = thread.getPc() - if_icmpge.length();
                    int if_icmpge_pc_next = if_icmpge_pc + if_icmpge_branch;
                    thread.setPc(if_icmpge_pc_next);
                }
                return;
            case INSTRUCTION_OPCODE_IF_ICMPGT:
                IF_ICMPGT if_icmpgt = (IF_ICMPGT)instruction;
                short if_icmpgt_branch = if_icmpgt.branch();
                int if_icmpgt_value2 = os.popInt();
                int if_icmpgt_value1 = os.popInt();
                if(if_icmpgt_value1 > if_icmpgt_value2){
                    int if_icmpgt_pc = thread.getPc() - if_icmpgt.length();
                    int if_icmpgt_pc_next = if_icmpgt_pc + if_icmpgt_branch;
                    thread.setPc(if_icmpgt_pc_next);
                }
                return;
            case INSTRUCTION_OPCODE_IF_ICMPLE:
                IF_ICMPLE if_icmple = (IF_ICMPLE)instruction;
                short if_icmple_branch = if_icmple.branch();
                int if_icmple_value2 = os.popInt();
                int if_icmple_value1 = os.popInt();
                if(if_icmple_value1 <= if_icmple_value2){
                    int if_icmple_pc = thread.getPc() - if_icmple.length();
                    int if_icmple_pc_next = if_icmple_pc + if_icmple_branch;
                    thread.setPc(if_icmple_pc_next);
                }
                return;
            case INSTRUCTION_OPCODE_IF_ICMPLT:
                IF_ICMPLT if_icmplt = (IF_ICMPLT)instruction;
                short if_icmplt_branch = if_icmplt.branch();
                int if_icmplt_value2 = os.popInt();
                int if_icmplt_value1 = os.popInt();
                if(if_icmplt_value1 < if_icmplt_value2){
                    int if_icmplt_pc = thread.getPc() - if_icmplt.length();
                    int if_icmplt_pc_next = if_icmplt_pc + if_icmplt_branch;
                    thread.setPc(if_icmplt_pc_next);
                }
                return;
            case INSTRUCTION_OPCODE_IFEQ:
                IFEQ ifeq = (IFEQ)instruction;
                short ifeq_branch = ifeq.branch();
                int ifeq_value = os.popInt();
                if(ifeq_value == 0){
                    int ifeq_pc = thread.getPc() - ifeq.length();
                    int ifeq_pc_next = ifeq_pc + ifeq_branch;
                    thread.setPc(ifeq_pc_next);
                }
                return;
            case INSTRUCTION_OPCODE_IFNE:
                IFNE ifne = (IFNE)instruction;
                short ifne_branch = ifne.branch();
                int ifne_value = os.popInt();
                if(ifne_value != 0){
                    int ifne_pc = thread.getPc() - ifne.length();
                    int ifne_pc_next = ifne_pc + ifne_branch;
                    thread.setPc(ifne_pc_next);
                }
                return;
            case INSTRUCTION_OPCODE_IFGE:
                IFGE ifge = (IFGE)instruction;
                short ifge_branch = ifge.branch();
                int ifge_value = os.popInt();
                if(ifge_value >= 0){
                    int ifge_pc = thread.getPc() - ifge.length();
                    int ifge_pc_next = ifge_pc + ifge_branch;
                    thread.setPc(ifge_pc_next);
                }
                return;
            case INSTRUCTION_OPCODE_IFGT:
                IFGT ifgt = (IFGT)instruction;
                short ifgt_branch = ifgt.branch();
                int ifgt_value = os.popInt();
                if(ifgt_value > 0){
                    int ifgt_pc = thread.getPc() - ifgt.length();
                    int ifgt_pc_next = ifgt_pc + ifgt_branch;
                    thread.setPc(ifgt_pc_next);
                }
                return;
            case INSTRUCTION_OPCODE_IFLE:
                IFLE ifle = (IFLE)instruction;
                short ifle_branch = ifle.branch();
                int ifle_value = os.popInt();
                if(ifle_value <= 0){
                    int ifle_pc = thread.getPc() - ifle.length();
                    int ifle_pc_next = ifle_pc + ifle_branch;
                    thread.setPc(ifle_pc_next);
                }
                return;
            case INSTRUCTION_OPCODE_IFLT:
                IFLT iflt = (IFLT)instruction;
                short iflt_branch = iflt.branch();
                int iflt_value = os.popInt();
                if(iflt_value < 0){
                    int iflt_pc = thread.getPc() - iflt.length();
                    int iflt_pc_next = iflt_pc + iflt_branch;
                    thread.setPc(iflt_pc_next);
                }
                return;


            // control instructions
            case INSTRUCTION_OPCODE_ARETURN:
                Frame areturn_current = thread.popFrame();
                int areturn_value = areturn_current.os().popRef();
                Frame areturn_before = thread.curFrame();
                areturn_before.os().pushRef(areturn_value);
                return;
            case INSTRUCTION_OPCODE_DRETURN:
                Frame dreturn_current = thread.popFrame();
                double dreturn_value = dreturn_current.os().popDouble();
                Frame dreturn_before = thread.curFrame();
                dreturn_before.os().pushDouble(dreturn_value);
                return;
            case INSTRUCTION_OPCODE_FRETURN:
                Frame freturn_current = thread.popFrame();
                float freturn_value = freturn_current.os().popFloat();
                Frame freturn_before = thread.curFrame();
                freturn_before.os().pushFloat(freturn_value);
                return;
            case INSTRUCTION_OPCODE_IRETURN:
                Frame ireturn_current = thread.popFrame();
                int ireturn_value = ireturn_current.os().popInt();
                Frame ireturn_before = thread.curFrame();
                ireturn_before.os().pushInt(ireturn_value);
                return;
            case INSTRUCTION_OPCODE_LRETURN:
                Frame lreturn_current = thread.popFrame();
                long lreturn_value = lreturn_current.os().popLong();
                Frame lreturn_before = thread.curFrame();
                lreturn_before.os().pushLong(lreturn_value);
                return;
            case INSTRUCTION_OPCODE_RETURN:
                thread.popFrame();
                return;
            case INSTRUCTION_OPCODE_GOTO:
                GOTO gotoInstruction = (GOTO)instruction;
                short goto_branch = gotoInstruction.branch();
                int goto_pc = thread.getPc() - gotoInstruction.length();
                short goto_pc_next = (short)(goto_pc + goto_branch);
                thread.setPc(goto_pc_next);
                return;
            case INSTRUCTION_OPCODE_JSR:
                throw new IllegalStateException("Unsupported");
            case INSTRUCTION_OPCODE_RET:
                throw new IllegalStateException("Unsupported");
            case INSTRUCTION_OPCODE_LOOKUPSWITCH:
                throw new IllegalStateException("Unsupported");
            case INSTRUCTION_OPCODE_TABLESWITCH:
                throw new IllegalStateException("Unsupported");
            // reference instructions
            case INSTRUCTION_OPCODE_NEWARRAY:
                throw new IllegalStateException("Unsupported");
            case INSTRUCTION_OPCODE_ANEWARRAY:
                throw new IllegalStateException("Unsupported");
            case INSTRUCTION_OPCODE_ARRAYLENGTH:
                throw new IllegalStateException("Unsupported");
            case INSTRUCTION_OPCODE_INVOKEVIRTUAL:
                invokeVirtualMethod(instruction, thread, heap, area);
                return;
            case INSTRUCTION_OPCODE_INVOKESPECIAL:
                invokeSpecialMethod(instruction, thread, heap, area);
                return;
            case INSTRUCTION_OPCODE_INVOKESTATIC:
                invokeStaticMethod(instruction, thread, heap, area);
                return;
            case INSTRUCTION_OPCODE_INVOKEINTERFACE:
                invokeInterfaceMethod(instruction, thread, heap, area);
                return;
            case INSTRUCTION_OPCODE_INVOKEDYNAMIC:
                throw new IllegalStateException("");
            case INSTRUCTION_OPCODE_MONITORENTER:
                throw new IllegalStateException("");
            case INSTRUCTION_OPCODE_MONITOREXIT:
                throw new IllegalStateException("");
            case INSTRUCTION_OPCODE_PUTSTATIC:
                PUTSTATIC putstaticInstruction = (PUTSTATIC)instruction;
                short putstaticInstruction_index = putstaticInstruction.index();
                KField putstaticInstruction_field = clazz.resolveFieldRef(putstaticInstruction_index);
                KClass putstaticInstruction_clazz = putstaticInstruction_field.getKClass();
                if(!putstaticInstruction_clazz.isClinited()) {
                    initializeClass(instruction, thread, heap, area, putstaticInstruction_clazz);
                    return;
                }
                if(!putstaticInstruction_field.isStatic()){
                    throw new IllegalStateException("");
                }
                if(putstaticInstruction_field.isFinal()){
                    if((clazz != putstaticInstruction_field.getKClass()) || (method.getName() != KMethod.clinitMethodName)){
                        throw new IllegalStateException("");
                    }
                }
                String putstaticInstruction_descriptor = putstaticInstruction_field.getDescriptor();
                char putstaticInstruction_type = putstaticInstruction_descriptor.charAt(0);
                int putstaticInstruction_slotid = putstaticInstruction_field.getSlotId();
                if(putstaticInstruction_type == 'Z'|| putstaticInstruction_type == 'B' || putstaticInstruction_type == 'C'
                        || putstaticInstruction_type == 'S' || putstaticInstruction_type == 'I'){
                    slots.setInt(putstaticInstruction_slotid, os.popInt());
                }
                else if(putstaticInstruction_type == 'F'){
                    slots.setFloat(putstaticInstruction_slotid, os.popFloat());
                }
                else if(putstaticInstruction_type == 'J'){
                    slots.setLong(putstaticInstruction_slotid, os.popLong());
                }
                else if(putstaticInstruction_type == 'D'){
                    slots.setDouble(putstaticInstruction_slotid, os.popDouble());
                }
                else if(putstaticInstruction_type == 'L' || putstaticInstruction_type == '['){
                    slots.setRef(putstaticInstruction_slotid, os.popRef());
                }
                else{
                    throw new IllegalStateException("");
                }
                return;
            case INSTRUCTION_OPCODE_GETSTATIC:
                GETSTATIC getstaticInstruction = (GETSTATIC)instruction;
                short getstaticInstruction_index = getstaticInstruction.index();
                KField getstaticInstruction_field = clazz.resolveFieldRef(getstaticInstruction_index);
                KClass getstaticInstruction_clazz = getstaticInstruction_field.getKClass();
                if(!getstaticInstruction_clazz.isClinited()) {
                    initializeClass(instruction, thread, heap, area, getstaticInstruction_clazz);
                    return;
                }
                if(!getstaticInstruction_field.isStatic()){
                    throw new IllegalStateException("");
                }
                String gettstaticInstruction_descriptor = getstaticInstruction_field.getDescriptor();
                char getstaticInstruction_type = gettstaticInstruction_descriptor.charAt(0);
                int getstaticInstruction_slotid = getstaticInstruction_field.getSlotId();
                if(getstaticInstruction_type == 'Z'|| getstaticInstruction_type == 'B' || getstaticInstruction_type == 'C'
                        || getstaticInstruction_type == 'S' || getstaticInstruction_type == 'I'){
                    os.pushInt(slots.getInt(getstaticInstruction_slotid));
                }
                else if(getstaticInstruction_type == 'F'){
                    os.pushFloat(slots.getFloat(getstaticInstruction_slotid));
                }
                else if(getstaticInstruction_type == 'J'){
                    os.pushLong(slots.getLong(getstaticInstruction_slotid));
                }
                else if(getstaticInstruction_type == 'D'){
                    os.pushDouble(slots.getDouble(getstaticInstruction_slotid));
                }
                else if(getstaticInstruction_type == 'L' || getstaticInstruction_type == '['){
                    os.pushRef(slots.getRef(getstaticInstruction_slotid));
                }
                else{
                    throw new IllegalStateException("");
                }
                return;
            case INSTRUCTION_OPCODE_PUTFIELD:
                PUTFIELD putfieldInstruction = (PUTFIELD)instruction;
                short putfieldInstruction_index = putfieldInstruction.index();
                KField putfieldInstruction_field = clazz.resolveFieldRef(putfieldInstruction_index);
                if(putfieldInstruction_field.isStatic()){
                    throw new IllegalStateException("");
                }
                if(putfieldInstruction_field.isFinal()){
                    if((clazz != putfieldInstruction_field.getKClass()) || (method.getName() != KMethod.initMethodName)){
                        throw new IllegalStateException("");
                    }
                }
                String putfieldInstruction_descriptor = putfieldInstruction_field.getDescriptor();
                char putfieldInstruction_type = putfieldInstruction_descriptor.charAt(0);
                int putfieldInstruction_slotid = putfieldInstruction_field.getSlotId();
                if(putfieldInstruction_type == 'Z'|| putfieldInstruction_type == 'B' || putfieldInstruction_type == 'C'
                        || putfieldInstruction_type == 'S' || putfieldInstruction_type == 'I'){
                    int value = os.popInt();
                    int ref = os.popRef();
                    KObject ref_object = heap.findObject(ref);
                    if(ref_object == null){
                        throw new IllegalStateException("");
                    }
                    LocalVariableTable ref_object_slots = ref_object.slots();
                    ref_object_slots.setInt(putfieldInstruction_slotid, value);
                }
                else if(putfieldInstruction_type == 'F'){
                    float value = os.popFloat();
                    int ref = os.popRef();
                    KObject ref_object = heap.findObject(ref);
                    if(ref_object == null){
                        throw new IllegalStateException("");
                    }
                    LocalVariableTable ref_object_slots = ref_object.slots();
                    ref_object_slots.setFloat(putfieldInstruction_slotid, value);
                }
                else if(putfieldInstruction_type == 'J'){
                    long value = os.popLong();
                    int ref = os.popRef();
                    KObject ref_object = heap.findObject(ref);
                    if(ref_object == null){
                        throw new IllegalStateException("");
                    }
                    LocalVariableTable ref_object_slots = ref_object.slots();
                    ref_object_slots.setLong(putfieldInstruction_slotid, value);
                }
                else if(putfieldInstruction_type == 'D'){
                    double value = os.popDouble();
                    int ref = os.popRef();
                    KObject ref_object = heap.findObject(ref);
                    if(ref_object == null){
                        throw new IllegalStateException("");
                    }
                    LocalVariableTable ref_object_slots = ref_object.slots();
                    ref_object_slots.setDouble(putfieldInstruction_slotid, value);
                }
                else if(putfieldInstruction_type == 'L' || putfieldInstruction_type == '['){
                    int value = os.popRef();
                    int ref = os.popRef();
                    KObject ref_object = heap.findObject(ref);
                    if(ref_object == null){
                        throw new IllegalStateException("");
                    }
                    LocalVariableTable ref_object_slots = ref_object.slots();
                    ref_object_slots.setRef(putfieldInstruction_slotid, value);
                }
                else{
                    throw new IllegalStateException("");
                }

                return;
            case INSTRUCTION_OPCODE_GETFIELD:
                GETFIELD getfieldInstruction = (GETFIELD)instruction;
                short getfieldInstruction_index = getfieldInstruction.index();
                KField getfieldInstruction_field = clazz.resolveFieldRef(getfieldInstruction_index);
                if(getfieldInstruction_field.isStatic()){
                    throw new IllegalStateException("");
                }
                int getfieldInstruction_ref = os.popRef();
                KObject getfieldInstruction_object = heap.findObject(getfieldInstruction_ref);
                if(getfieldInstruction_object == null){
                    throw new IllegalStateException("");
                }
                LocalVariableTable getfieldInstruction_object_slots = getfieldInstruction_object.slots();
                String getfieldInstruction_descriptor = getfieldInstruction_field.getDescriptor();
                char getfieldInstruction_type = getfieldInstruction_descriptor.charAt(0);
                int getfieldInstruction_slotid = getfieldInstruction_field.getSlotId();
                if(getfieldInstruction_type == 'Z'|| getfieldInstruction_type == 'B' || getfieldInstruction_type == 'C'
                        || getfieldInstruction_type == 'S' || getfieldInstruction_type == 'I'){
                    os.pushInt(getfieldInstruction_object_slots.getInt(getfieldInstruction_slotid));
                }
                else if(getfieldInstruction_type == 'F'){
                    os.pushFloat(getfieldInstruction_object_slots.getFloat(getfieldInstruction_slotid));
                }
                else if(getfieldInstruction_type == 'J'){
                    os.pushLong(getfieldInstruction_object_slots.getLong(getfieldInstruction_slotid));
                }
                else if(getfieldInstruction_type == 'D'){
                    os.pushDouble(getfieldInstruction_object_slots.getDouble(getfieldInstruction_slotid));
                }
                else if(getfieldInstruction_type == 'L' || getfieldInstruction_type == '['){
                    os.pushRef(getfieldInstruction_object_slots.getRef(getfieldInstruction_slotid));
                }
                else{
                    throw new IllegalStateException("");
                }
                return;
            case INSTRUCTION_OPCODE_NEW:
                NEW newInstruction = (NEW)instruction;
                short newInstruction_index = newInstruction.index();
                KClass newInstruction_clazz = clazz.resolveClassRef(newInstruction_index);
                if(!newInstruction_clazz.isClinited()) {
                    initializeClass(instruction, thread, heap, area, newInstruction_clazz);
                    return;
                }
                if(newInstruction_clazz.isInterface() || newInstruction_clazz.isAbstract()){
                    throw new IllegalStateException("");
                }
                KObject newInstruction_object = heap.newObject(newInstruction_clazz);
                os.pushRef(newInstruction_object.id());
                return;
            case INSTRUCTION_OPCODE_CHECKCAST:
                CHECKCAST checkcastInstruction = (CHECKCAST)instruction;
                short checkcastInstruction_index = checkcastInstruction.index();
                KClass checkcastInstruction_clazz = clazz.resolveClassRef(checkcastInstruction_index);
                int checkcastInstruction_ref = os.popRef();
                if(checkcastInstruction_ref == 0){
                    return;
                }
                KObject checkcastInstruction_ref_object = heap.findObject(checkcastInstruction_ref);
                KClass checkcastInstruction_ref_class = checkcastInstruction_ref_object.clazz();
                if(!checkcastInstruction_ref_class.isSubClassOf(checkcastInstruction_clazz)){
                    throw new IllegalStateException("");
                }
                return;
            case INSTRUCTION_OPCODE_INSTANCEOF:
                INSTANCEOF instanceofInstruction = (INSTANCEOF)instruction;
                short instanceofInstruction_index = instanceofInstruction.index();
                KClass instanceofInstruction_clazz = clazz.resolveClassRef(instanceofInstruction_index);
                int instanceofInstruction_ref = os.popRef();
                if(instanceofInstruction_ref == 0){
                    os.pushInt(0);
                    return;
                }
                KObject instanceofInstruction_ref_object = heap.findObject(instanceofInstruction_ref);
                KClass instanceofInstruction_ref_class = instanceofInstruction_ref_object.clazz();
                if(instanceofInstruction_ref_class.isSubClassOf(instanceofInstruction_clazz)){
                    os.pushInt(1);
                }
                else{
                    os.pushInt(0);
                }
                return;
            case INSTRUCTION_OPCODE_ATHROW:
                throw new IllegalStateException("Unsupported");

            // extended instructions
            case INSTRUCTION_OPCODE_GOTO_W:
                GOTO_W gotowInstruction = (GOTO_W)instruction;
                int gotow_branch = gotowInstruction.branch();
                int gotow_pc = thread.getPc() - gotowInstruction.length();
                int gotow_pc_next = (short)(gotow_pc + gotow_branch);
                thread.setPc(gotow_pc_next);
                return;
            case INSTRUCTION_OPCODE_IFNONNULL:
                IFNONNULL ifnonnull = (IFNONNULL)instruction;
                short ifnonnull_branch = ifnonnull.branch();
                int ifnonnull_value = os.popRef();
                if(ifnonnull_value != 0){
                    int ifnonnull_pc = thread.getPc() - ifnonnull.length() ;
                    int ifnonnull_pc_next = ifnonnull_pc + ifnonnull_branch;
                    thread.setPc(ifnonnull_pc_next);
                }
                return;
            case INSTRUCTION_OPCODE_IFNULL:
                IFNULL ifnull = (IFNULL)instruction;
                short ifnull_branch = ifnull.branch();
                int ifnull_value = os.popRef();
                if(ifnull_value == 0){
                    int ifnull_pc = thread.getPc() - ifnull.length();
                    int ifnull_pc_next = ifnull_pc + ifnull_branch;
                    thread.setPc(ifnull_pc_next);
                }
                return;
            case INSTRUCTION_OPCODE_JSR_W:
                throw new IllegalStateException("Unsupported");
            case INSTRUCTION_OPCODE_MULTIANEWARRAY:
                throw new IllegalStateException("");
            case INSTRUCTION_OPCODE_WIDE:
                throw new IllegalStateException("");

            // reserved instructions
            case INSTRUCTION_OPCODE_BREAKPOINT:
                throw new IllegalStateException("");
            case INSTRUCTION_OPCODE_IMPDEP1:
                throw new IllegalStateException("");
            case INSTRUCTION_OPCODE_IMPDEP2:
                throw new IllegalStateException("");
        }
    }

    // static method
    private void invokeStaticMethod(Instruction instruction, Thread thread, Heap heap, MethodArea area) {
        Frame cur = thread.curFrame();
        KClass clazz = cur.clazz();
        ConstantInfo[] cp = clazz.getConstantPool();

        // hack a little
        if(clazz.getName().equals("java/lang/Object")){
            return;
        }

        INVOKESTATIC invokestaticInstruction = (INVOKESTATIC)instruction;
        short invokestatic_index = invokestaticInstruction.index();
        KMethod invokestatic_method = null;

        if(ConstantInfo.isMethodref(cp[invokestatic_index])){
            invokestatic_method = clazz.resolveMethodRef(invokestatic_index);
        }
        else if(ConstantInfo.isInterfaceMethodref(cp[invokestatic_index])){
            invokestatic_method = clazz.resolveInterfaceMethodRef(invokestatic_index);
        }
        else{
            throw new IllegalStateException("");
        }

        if(invokestatic_method == null){
            throw new IllegalStateException("NoSuchMethodError");
        }

        if(!invokestatic_method.isStatic()){
            throw new IllegalStateException("IncompatibleClassChangeError");
        }

        if(invokestatic_method.isNative()){
            throw new IllegalStateException("Native is not supported yet");
        }

        Frame next = new Frame(invokestatic_method);
        thread.pushFrame(next);

        // pop arguments from current operand stack of current method to next lvr of next method
        OperandStack curOperandStack = cur.os();
        LocalVariableTable nextLocalVariableTable = next.lvt();
        for(int i = invokestatic_method.getArgSlotsCount() - 1; i >= 0 ; i--){
            int slot = curOperandStack.popSlot();
            nextLocalVariableTable.setSlot(i ,slot);
        }
    }

    // invoke normal object methods
    private void invokeVirtualMethod(Instruction instruction, Thread thread, Heap heap, MethodArea area) {
        Frame cur = thread.curFrame();
        KClass clazz = cur.clazz();
        KClass superclazz = clazz.getSuperClass();
        OperandStack os = cur.os();
        ConstantInfo[] cp = clazz.getConstantPool();

        INVOKEVIRTUAL invokevirtual = (INVOKEVIRTUAL)instruction;
        short index = invokevirtual.index();
        KMethod method = clazz.resolveMethodRef(index);
        if(method.isInitMethod()){
            throw new IllegalStateException("IncompatibleClassChangeError");
        }
        if(method.isClinitMethod()){
            throw new IllegalStateException("IncompatibleClassChangeError");
        }
        if(method.isStatic()){
            throw new IllegalStateException("IncompatibleClassChangeError");
        }

        String name = method.getName();
        String descriptor = method.getDescriptor();

        int objectref_n = method.getArgSlotsCount();
        int objectref = os.topSlotAtN(objectref_n);
        if(objectref == 0){
            throw new IllegalStateException("NullPointerException");
        }
        KObject objectref_object = heap.findObject(objectref);
        KClass objectref_clazz = objectref_object.clazz();
        if(method.isProtected()
                && (superclazz.findMethod(name, descriptor) != null)
                && !objectref_clazz.getPackageName().equals(clazz.getPackageName())){
            if(!objectref_clazz.isSubClassOf(clazz)){
                throw new IllegalStateException("IllegalAccessError");
            }
        }

        Frame next = new Frame(method);
        thread.pushFrame(next);

        // pop arguments from current operand stack of current method to next lvr of next method
        OperandStack curOperandStack = cur.os();
        LocalVariableTable nextLocalVariableTable = next.lvt();
        for(int i = method.getArgSlotsCount(); i > 0 ; i--){
            int slot = curOperandStack.popSlot();
            nextLocalVariableTable.setSlot(i ,slot);
        }

        // pop objectref from current operand stack of current method to next lvr of next method
        int invokevirtual_objectref = curOperandStack.popRef();
        if(invokevirtual_objectref == 0){
            throw new IllegalStateException("NullPointerException");
        }
        nextLocalVariableTable.setRef(0, invokevirtual_objectref);
    }

    // invoke special object methods
    // (1) private methods of current class
    // (2) <init> methods of current class
    // (3) super class's methods, the method shall be used like super.method()
    private void invokeSpecialMethod(Instruction instruction, Thread thread, Heap heap, MethodArea area) {
        Frame cur = thread.curFrame();
        KClass clazz = cur.clazz();
        ConstantInfo[] cp = clazz.getConstantPool();
        OperandStack os = cur.os();
        KClass superclazz = clazz.getSuperClass();

        INVOKESPECIAL invokespecial = (INVOKESPECIAL)instruction;
        short index = invokespecial.index();
        KMethod method = null;
        if(ConstantInfo.isMethodref(cp[index])){
            method = clazz.resolveMethodRef(index);

            if(clazz.isSuper() && clazz.isSubClassOf(method.clazz()) && !method.isInitMethod()){
                method = superclazz.findMethod(method.getName(), method.getDescriptor());
            }

        }
        else if(ConstantInfo.isInterfaceMethodref(cp[index])){
            method = clazz.resolveInterfaceMethodRef(index);
        }
        else{
            throw new IllegalStateException("");
        }

        if(method == null){
            throw new IllegalStateException("NoSuchMethodError");
        }

        if(method.isStatic()){
            throw new IllegalStateException("IncompatibleClassChangeError");
        }

        if(method.isNative()){
            throw new IllegalStateException("Native is not supported yet");
        }

        if(method.isAbstract()){
            throw new IllegalStateException("AbstractMethodError");
        }

        String name = method.getName();
        String descriptor = method.getDescriptor();

        int objectref_n = method.getArgSlotsCount();
        int objectref = os.topSlotAtN(objectref_n);
        if(objectref == 0){
            throw new IllegalStateException("NullPointerException");
        }
        KObject objectref_object = heap.findObject(objectref);
        KClass objectref_clazz = objectref_object.clazz();
        if(method.isProtected()
                && (superclazz.findMethod(name, descriptor) != null)
                && !objectref_clazz.getPackageName().equals(clazz.getPackageName())){
            if(!objectref_clazz.isSubClassOf(clazz)){
                throw new IllegalStateException("IllegalAccessError");
            }
        }

        Frame next = new Frame(method);
        thread.pushFrame(next);

        // pop arguments from current operand stack of current method to next lvr of next method
        LocalVariableTable nextLocalVariableTable = next.lvt();
        for(int i = method.getArgSlotsCount(); i > 0 ; i--){
            int slot = os.popSlot();
            nextLocalVariableTable.setSlot(i ,slot);
        }

        // pop objectref from current operand stack of current method to next lvr of next method
        int invokespecial_objectref = os.popRef();
        nextLocalVariableTable.setRef(0, invokespecial_objectref);
    }

    private void invokeInterfaceMethod(Instruction instruction, Thread thread, Heap heap, MethodArea area) {
        Frame cur = thread.curFrame();
        KClass clazz = cur.clazz();
        ConstantInfo[] cp = clazz.getConstantPool();
        OperandStack os = cur.os();

        INVOKEINTERFACE invokeinterface = (INVOKEINTERFACE)instruction;
        short index = invokeinterface.index();
        KMethod method = clazz.resolveInterfaceMethodRef(index);
        if(method.isInitMethod()){
            throw new IllegalStateException("IncompatibleClassChangeError");
        }
        if(method.isClinitMethod()){
            throw new IllegalStateException("IncompatibleClassChangeError");
        }
        if(method.isStatic() || method.isPrivate()){
            throw new IllegalStateException("IncompatibleClassChangeError");
        }

        String name = method.getName();
        String descriptor = method.getDescriptor();

        int objectref_n = method.getArgSlotsCount();
        int objectref = os.topSlotAtN(objectref_n);
        if(objectref == 0){
            throw new IllegalStateException("NullPointerException");
        }
        KObject objectref_object = heap.findObject(objectref);
        KClass objectref_clazz = objectref_object.clazz();

        KMethod objectref_method = objectref_clazz.findMethod(name,descriptor);

        if(!objectref_method.isPublic()){
            throw new IllegalStateException("IllegalAccessError");
        }

        if(objectref_method.isAbstract()){
            throw new IllegalStateException("AbstractMethodError");
        }

        if(objectref_method.isNative()){
            throw new IllegalStateException("Native is not supported yet");
        }

        Frame next = new Frame(objectref_method);
        thread.pushFrame(next);

        // pop arguments from current operand stack of current method to next lvr of next method
        LocalVariableTable nextLocalVariableTable = next.lvt();
        for(int i = objectref_method.getArgSlotsCount(); i > 0 ; i--){
            int slot = os.popSlot();
            nextLocalVariableTable.setSlot(i ,slot);
        }

        // pop objectref from current operand stack of current method to next lvr of next method
        int invokeinterface_objectref = os.popRef();
        nextLocalVariableTable.setRef(0, invokeinterface_objectref);
    }

    // see jvm 5.5
    // the instruction, including NEW, GETSTATIC, PUTSTATIC, INVOKESTATIC
    private void initializeClass(Instruction instruction, Thread thread, Heap heap, MethodArea area, KClass kclazz){
        Frame cur = null, next = null;

        // invoke <clinit> method to do initialize operation
        KMethod clinitMethod = kclazz.getClinitMethod();
        // it is ok that the class has no clinit method
        if(clinitMethod == null){
            return;
        }

        int pc = thread.getPc() - instruction.length();
        next = new Frame(clinitMethod);
        thread.pushFrame(next, pc);
        kclazz.markClinited();

        // do super class
        for(KClass superclazz = kclazz.getSuperClass(); superclazz != null; superclazz = superclazz.getSuperClass()) {
            if(superclazz.isClinited())
                break;

            KMethod superclazzClinitMethod = superclazz.getClinitMethod();
            if(superclazzClinitMethod != null) {
                next = new Frame(superclazzClinitMethod);
                thread.pushFrame(next);
            }
            superclazz.markClinited();
        }
    }
}
