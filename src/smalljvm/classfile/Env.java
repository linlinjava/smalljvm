package smalljvm.classfile;

public class Env
{
    public static final int MAGIC = 0xCAFEBABE;

    public static final int CLASS_VERSION_1_0_MAJOR = 45;
    public static final int CLASS_VERSION_1_0_MINOR = 3;
    public static final int CLASS_VERSION_1_2_MAJOR = 46;
    public static final int CLASS_VERSION_1_2_MINOR = 0;
    public static final int CLASS_VERSION_1_3_MAJOR = 47;
    public static final int CLASS_VERSION_1_3_MINOR = 0;
    public static final int CLASS_VERSION_1_4_MAJOR = 48;
    public static final int CLASS_VERSION_1_4_MINOR = 0;
    public static final int CLASS_VERSION_1_5_MAJOR = 49;
    public static final int CLASS_VERSION_1_5_MINOR = 0;
    public static final int CLASS_VERSION_1_6_MAJOR = 50;
    public static final int CLASS_VERSION_1_6_MINOR = 0;
    public static final int CLASS_VERSION_1_7_MAJOR = 51;
    public static final int CLASS_VERSION_1_7_MINOR = 0;
    public static final int CLASS_VERSION_1_8_MAJOR = 52;
    public static final int CLASS_VERSION_1_8_MINOR = 0;

    public static final int CLASS_VERSION_1_0 = (CLASS_VERSION_1_0_MAJOR << 16) | CLASS_VERSION_1_0_MINOR;
    public static final int CLASS_VERSION_1_2 = (CLASS_VERSION_1_2_MAJOR << 16) | CLASS_VERSION_1_2_MINOR;
    public static final int CLASS_VERSION_1_3 = (CLASS_VERSION_1_3_MAJOR << 16) | CLASS_VERSION_1_3_MINOR;
    public static final int CLASS_VERSION_1_4 = (CLASS_VERSION_1_4_MAJOR << 16) | CLASS_VERSION_1_4_MINOR;
    public static final int CLASS_VERSION_1_5 = (CLASS_VERSION_1_5_MAJOR << 16) | CLASS_VERSION_1_5_MINOR;
    public static final int CLASS_VERSION_1_6 = (CLASS_VERSION_1_6_MAJOR << 16) | CLASS_VERSION_1_6_MINOR;
    public static final int CLASS_VERSION_1_7 = (CLASS_VERSION_1_7_MAJOR << 16) | CLASS_VERSION_1_7_MINOR;
    public static final int CLASS_VERSION_1_8 = (CLASS_VERSION_1_8_MAJOR << 16) | CLASS_VERSION_1_8_MINOR;

    public static final int ACC_PUBLIC       = 0x0001;
    public static final int ACC_PRIVATE      = 0x0002;
    public static final int ACC_PROTECTED    = 0x0004;
    public static final int ACC_STATIC       = 0x0008;
    public static final int ACC_FINAL        = 0x0010;
    public static final int ACC_SUPER        = 0x0020;
    public static final int ACC_SYNCHRONIZED = 0x0020;
    public static final int ACC_VOLATILE     = 0x0040;
    public static final int ACC_TRANSIENT    = 0x0080;
    public static final int ACC_BRIDGE       = 0x0040;
    public static final int ACC_VARARGS      = 0x0080;
    public static final int ACC_NATIVE       = 0x0100;
    public static final int ACC_INTERFACE    = 0x0200;
    public static final int ACC_ABSTRACT     = 0x0400;
    public static final int ACC_STRICT       = 0x0800;
    public static final int ACC_SYNTHETIC    = 0x1000;
    public static final int ACC_ANNOTATION = 0x2000;
    public static final int ACC_ENUM         = 0x4000;
    public static final int ACC_MANDATED     = 0x8000;

    public static final int VALID_ACC_CLASS     =
                                                    ACC_PUBLIC       |
                                                    ACC_FINAL        |
                                                    ACC_SUPER        |
                                                    ACC_INTERFACE    |
                                                    ACC_ABSTRACT     |
                                                    ACC_SYNTHETIC    |
                                                    ACC_ANNOTATION |
                                                    ACC_ENUM;

    public static final int VALID_ACC_FIELD     =
                                                    ACC_PUBLIC       |
                                                    ACC_PRIVATE      |
                                                    ACC_PROTECTED    |
                                                    ACC_STATIC       |
                                                    ACC_FINAL        |
                                                    ACC_VOLATILE     |
                                                    ACC_TRANSIENT    |
                                                    ACC_SYNTHETIC    |
                                                    ACC_ENUM;

    public static final int VALID_ACC_METHOD    =
                                                    ACC_PUBLIC       |
                                                    ACC_PRIVATE      |
                                                    ACC_PROTECTED    |
                                                    ACC_STATIC       |
                                                    ACC_FINAL        |
                                                    ACC_SYNCHRONIZED |
                                                    ACC_BRIDGE       |
                                                    ACC_VARARGS      |
                                                    ACC_NATIVE       |
                                                    ACC_ABSTRACT     |
                                                    ACC_STRICT       |
                                                    ACC_SYNTHETIC;

    public static final int VALID_ACC_PARAMETER =
                                                    ACC_FINAL        |
                                                    ACC_SYNTHETIC    |
                                                    ACC_MANDATED;

    public static final int TAG_CONSTANT_Utf8               = 1;
    public static final int TAG_CONSTANT_Integer            = 3;
    public static final int TAG_CONSTANT_Float              = 4;
    public static final int TAG_CONSTANT_Long               = 5;
    public static final int TAG_CONSTANT_Double             = 6;
    public static final int TAG_CONSTANT_Class              = 7;
    public static final int TAG_CONSTANT_String             = 8;
    public static final int TAG_CONSTANT_Fieldref           = 9;
    public static final int TAG_CONSTANT_Methodref          = 10;
    public static final int TAG_CONSTANT_InterfaceMethodref = 11;
    public static final int TAG_CONSTANT_NameAndType        = 12;
    public static final int TAG_CONSTANT_MethodHandle       = 15;
    public static final int TAG_CONSTANT_MethodType         = 16;
    public static final int TAG_CONSTANT_InvokeDynamic      = 18;

    public static final int REF_getField         = 1;
    public static final int REF_getStatic        = 2;
    public static final int REF_putField         = 3;
    public static final int REF_putStatic        = 4;
    public static final int REF_invokeVirtual    = 5;
    public static final int REF_invokeStatic     = 6;
    public static final int REF_invokeSpecial    = 7;
    public static final int REF_newInvokeSpecial = 8;
    public static final int REF_invokeInterface  = 9;

    public static final String ATTRIBUTE_NAME_BootstrapMethods                     = "BootstrapMethods";
    public static final String ATTRIBUTE_NAME_SourceFile                           = "SourceFile";
    public static final String ATTRIBUTE_NAME_SourceDebugExtension                = "SourceDebugExtension";
    public static final String ATTRIBUTE_NAME_InnerClasses                         = "InnerClasses";
    public static final String ATTRIBUTE_NAME_EnclosingMethod                      = "EnclosingMethod";
    public static final String ATTRIBUTE_NAME_Deprecated                           = "Deprecated";
    public static final String ATTRIBUTE_NAME_Synthetic                            = "Synthetic";
    public static final String ATTRIBUTE_NAME_Signature                            = "Signature";
    public static final String ATTRIBUTE_NAME_ConstantValue                        = "ConstantValue";
    public static final String ATTRIBUTE_NAME_MethodParameters                     = "MethodParameters";
    public static final String ATTRIBUTE_NAME_Exceptions                           = "Exceptions";
    public static final String ATTRIBUTE_NAME_Code                                 = "Code";
    public static final String ATTRIBUTE_NAME_StackMapTable                        = "StackMapTable";
    public static final String ATTRIBUTE_NAME_LineNumberTable                      = "LineNumberTable";
    public static final String ATTRIBUTE_NAME_LocalVariableTable                   = "LocalVariableTable";
    public static final String ATTRIBUTE_NAME_LocalVariableTypeTable               = "LocalVariableTypeTable";
    public static final String ATTRIBUTE_NAME_RuntimeVisibleAnnotations            = "RuntimeVisibleAnnotations";
    public static final String ATTRIBUTE_NAME_RuntimeInvisibleAnnotations          = "RuntimeInvisibleAnnotations";
    public static final String ATTRIBUTE_NAME_RuntimeVisibleParameterAnnotations   = "RuntimeVisibleParameterAnnotations";
    public static final String ATTRIBUTE_NAME_RuntimeInvisibleParameterAnnotations = "RuntimeInvisibleParameterAnnotations";
    public static final String ATTRIBUTE_NAME_RuntimeVisibleTypeAnnotations        = "RuntimeVisibleTypeAnnotations";
    public static final String ATTRIBUTE_NAME_RuntimeInvisibleTypeAnnotations      = "RuntimeInvisibleTypeAnnotations";
    public static final String ATTRIBUTE_NAME_AnnotationDefault                    = "AnnotationDefault";

    public static final int ANNOTATION_TARGET_ParameterGenericClass             = 0x00;
    public static final int ANNOTATION_TARGET_ParameterGenericMethod            = 0x01;
    public static final int ANNOTATION_TARGET_Extends                           = 0x10;
    public static final int ANNOTATION_TARGET_BoundGenericClass                 = 0x11;
    public static final int ANNOTATION_TARGET_BoundGenericMethod                = 0x12;
    public static final int ANNOTATION_TARGET_Field                             = 0x13;
    public static final int ANNOTATION_TARGET_Return                            = 0x14;
    public static final int ANNOTATION_TARGET_Receiver                          = 0x15;
    public static final int ANNOTATION_TARGET_Parameter                         = 0x16;
    public static final int ANNOTATION_TARGET_Throws                            = 0x17;
    public static final int ANNOTATION_TARGET_LocalVariable                     = 0x40;
    public static final int ANNOTATION_TARGET_ResourceVariable                  = 0x41;
    public static final int ANNOTATION_TARGET_Catch                             = 0x42;
    public static final int ANNOTATION_TARGET_InstanceOf                        = 0x43;
    public static final int ANNOTATION_TARGET_New                               = 0x44;
    public static final int ANNOTATION_TARGET_MethodReferenceNew                = 0x45;
    public static final int ANNOTATION_TARGET_MethodReference                   = 0x46;
    public static final int ANNOTATION_TARGET_Cast                              = 0x47;
    public static final int ANNOTATION_TARGET_ArgumentGenericMethodNew          = 0x48;
    public static final int ANNOTATION_TARGET_ArgumentGenericMethod             = 0x49;
    public static final int ANNOTATION_TARGET_ArgumentGenericMethodReferenceNew = 0x4a;
    public static final int ANNOTATION_TARGET_ArgumentGenericMethodReference    = 0x4b;


    public static final byte INSTRUCTION_OPCODE_NOP              = (byte)0;
    public static final byte INSTRUCTION_OPCODE_ACONST_NULL     = (byte)1;
    public static final byte INSTRUCTION_OPCODE_ICONST_M1       = (byte)2;
    public static final byte INSTRUCTION_OPCODE_ICONST_0        = (byte)3;
    public static final byte INSTRUCTION_OPCODE_ICONST_1        = (byte)4;
    public static final byte INSTRUCTION_OPCODE_ICONST_2        = (byte)5;
    public static final byte INSTRUCTION_OPCODE_ICONST_3        = (byte)6;
    public static final byte INSTRUCTION_OPCODE_ICONST_4        = (byte)7;
    public static final byte INSTRUCTION_OPCODE_ICONST_5        = (byte)8;
    public static final byte INSTRUCTION_OPCODE_LCONST_0        = (byte)9;
    public static final byte INSTRUCTION_OPCODE_LCONST_1        = (byte)10;
    public static final byte INSTRUCTION_OPCODE_FCONST_0        = (byte)11;
    public static final byte INSTRUCTION_OPCODE_FCONST_1        = (byte)12;
    public static final byte INSTRUCTION_OPCODE_FCONST_2        = (byte)13;
    public static final byte INSTRUCTION_OPCODE_DCONST_0        = (byte)14;
    public static final byte INSTRUCTION_OPCODE_DCONST_1        = (byte)15;
    public static final byte INSTRUCTION_OPCODE_BIPUSH          = (byte)16;
    public static final byte INSTRUCTION_OPCODE_SIPUSH          = (byte)17;
    public static final byte INSTRUCTION_OPCODE_LDC             = (byte)18;
    public static final byte INSTRUCTION_OPCODE_LDC_W           = (byte)19;
    public static final byte INSTRUCTION_OPCODE_LDC2_W          = (byte)20;
    public static final byte INSTRUCTION_OPCODE_ILOAD           = (byte)21;
    public static final byte INSTRUCTION_OPCODE_LLOAD           = (byte)22;
    public static final byte INSTRUCTION_OPCODE_FLOAD           = (byte)23;
    public static final byte INSTRUCTION_OPCODE_DLOAD           = (byte)24;
    public static final byte INSTRUCTION_OPCODE_ALOAD           = (byte)25;
    public static final byte INSTRUCTION_OPCODE_ILOAD_0         = (byte)26;
    public static final byte INSTRUCTION_OPCODE_ILOAD_1         = (byte)27;
    public static final byte INSTRUCTION_OPCODE_ILOAD_2         = (byte)28;
    public static final byte INSTRUCTION_OPCODE_ILOAD_3         = (byte)29;
    public static final byte INSTRUCTION_OPCODE_LLOAD_0         = (byte)30;
    public static final byte INSTRUCTION_OPCODE_LLOAD_1         = (byte)31;
    public static final byte INSTRUCTION_OPCODE_LLOAD_2         = (byte)32;
    public static final byte INSTRUCTION_OPCODE_LLOAD_3         = (byte)33;
    public static final byte INSTRUCTION_OPCODE_FLOAD_0         = (byte)34;
    public static final byte INSTRUCTION_OPCODE_FLOAD_1         = (byte)35;
    public static final byte INSTRUCTION_OPCODE_FLOAD_2         = (byte)36;
    public static final byte INSTRUCTION_OPCODE_FLOAD_3         = (byte)37;
    public static final byte INSTRUCTION_OPCODE_DLOAD_0         = (byte)38;
    public static final byte INSTRUCTION_OPCODE_DLOAD_1         = (byte)39;
    public static final byte INSTRUCTION_OPCODE_DLOAD_2         = (byte)40;
    public static final byte INSTRUCTION_OPCODE_DLOAD_3         = (byte)41;
    public static final byte INSTRUCTION_OPCODE_ALOAD_0         = (byte)42;
    public static final byte INSTRUCTION_OPCODE_ALOAD_1         = (byte)43;
    public static final byte INSTRUCTION_OPCODE_ALOAD_2         = (byte)44;
    public static final byte INSTRUCTION_OPCODE_ALOAD_3         = (byte)45;
    public static final byte INSTRUCTION_OPCODE_IALOAD          = (byte)46;
    public static final byte INSTRUCTION_OPCODE_LALOAD          = (byte)47;
    public static final byte INSTRUCTION_OPCODE_FALOAD          = (byte)48;
    public static final byte INSTRUCTION_OPCODE_DALOAD          = (byte)49;
    public static final byte INSTRUCTION_OPCODE_AALOAD          = (byte)50;
    public static final byte INSTRUCTION_OPCODE_BALOAD          = (byte)51;
    public static final byte INSTRUCTION_OPCODE_CALOAD          = (byte)52;
    public static final byte INSTRUCTION_OPCODE_SALOAD          = (byte)53;
    public static final byte INSTRUCTION_OPCODE_ISTORE          = (byte)54;
    public static final byte INSTRUCTION_OPCODE_LSTORE          = (byte)55;
    public static final byte INSTRUCTION_OPCODE_FSTORE          = (byte)56;
    public static final byte INSTRUCTION_OPCODE_DSTORE          = (byte)57;
    public static final byte INSTRUCTION_OPCODE_ASTORE          = (byte)58;
    public static final byte INSTRUCTION_OPCODE_ISTORE_0        = (byte)59;
    public static final byte INSTRUCTION_OPCODE_ISTORE_1        = (byte)60;
    public static final byte INSTRUCTION_OPCODE_ISTORE_2        = (byte)61;
    public static final byte INSTRUCTION_OPCODE_ISTORE_3        = (byte)62;
    public static final byte INSTRUCTION_OPCODE_LSTORE_0        = (byte)63;
    public static final byte INSTRUCTION_OPCODE_LSTORE_1        = (byte)64;
    public static final byte INSTRUCTION_OPCODE_LSTORE_2        = (byte)65;
    public static final byte INSTRUCTION_OPCODE_LSTORE_3        = (byte)66;
    public static final byte INSTRUCTION_OPCODE_FSTORE_0        = (byte)67;
    public static final byte INSTRUCTION_OPCODE_FSTORE_1        = (byte)68;
    public static final byte INSTRUCTION_OPCODE_FSTORE_2        = (byte)69;
    public static final byte INSTRUCTION_OPCODE_FSTORE_3        = (byte)70;
    public static final byte INSTRUCTION_OPCODE_DSTORE_0        = (byte)71;
    public static final byte INSTRUCTION_OPCODE_DSTORE_1        = (byte)72;
    public static final byte INSTRUCTION_OPCODE_DSTORE_2        = (byte)73;
    public static final byte INSTRUCTION_OPCODE_DSTORE_3        = (byte)74;
    public static final byte INSTRUCTION_OPCODE_ASTORE_0        = (byte)75;
    public static final byte INSTRUCTION_OPCODE_ASTORE_1        = (byte)76;
    public static final byte INSTRUCTION_OPCODE_ASTORE_2        = (byte)77;
    public static final byte INSTRUCTION_OPCODE_ASTORE_3        = (byte)78;
    public static final byte INSTRUCTION_OPCODE_IASTORE         = (byte)79;
    public static final byte INSTRUCTION_OPCODE_LASTORE         = (byte)80;
    public static final byte INSTRUCTION_OPCODE_FASTORE         = (byte)81;
    public static final byte INSTRUCTION_OPCODE_DASTORE         = (byte)82;
    public static final byte INSTRUCTION_OPCODE_AASTORE         = (byte)83;
    public static final byte INSTRUCTION_OPCODE_BASTORE         = (byte)84;
    public static final byte INSTRUCTION_OPCODE_CASTORE         = (byte)85;
    public static final byte INSTRUCTION_OPCODE_SASTORE         = (byte)86;
    public static final byte INSTRUCTION_OPCODE_POP             = (byte)87;
    public static final byte INSTRUCTION_OPCODE_POP2            = (byte)88;
    public static final byte INSTRUCTION_OPCODE_DUP             = (byte)89;
    public static final byte INSTRUCTION_OPCODE_DUP_X1          = (byte)90;
    public static final byte INSTRUCTION_OPCODE_DUP_X2          = (byte)91;
    public static final byte INSTRUCTION_OPCODE_DUP2            = (byte)92;
    public static final byte INSTRUCTION_OPCODE_DUP2_X1         = (byte)93;
    public static final byte INSTRUCTION_OPCODE_DUP2_X2         = (byte)94;
    public static final byte INSTRUCTION_OPCODE_SWAP            = (byte)95;
    public static final byte INSTRUCTION_OPCODE_IADD            = (byte)96;
    public static final byte INSTRUCTION_OPCODE_LADD            = (byte)97;
    public static final byte INSTRUCTION_OPCODE_FADD            = (byte)98;
    public static final byte INSTRUCTION_OPCODE_DADD            = (byte)99;
    public static final byte INSTRUCTION_OPCODE_ISUB            = (byte)100;
    public static final byte INSTRUCTION_OPCODE_LSUB            = (byte)101;
    public static final byte INSTRUCTION_OPCODE_FSUB            = (byte)102;
    public static final byte INSTRUCTION_OPCODE_DSUB            = (byte)103;
    public static final byte INSTRUCTION_OPCODE_IMUL            = (byte)104;
    public static final byte INSTRUCTION_OPCODE_LMUL            = (byte)105;
    public static final byte INSTRUCTION_OPCODE_FMUL            = (byte)106;
    public static final byte INSTRUCTION_OPCODE_DMUL            = (byte)107;
    public static final byte INSTRUCTION_OPCODE_IDIV            = (byte)108;
    public static final byte INSTRUCTION_OPCODE_LDIV            = (byte)109;
    public static final byte INSTRUCTION_OPCODE_FDIV            = (byte)110;
    public static final byte INSTRUCTION_OPCODE_DDIV            = (byte)111;
    public static final byte INSTRUCTION_OPCODE_IREM            = (byte)112;
    public static final byte INSTRUCTION_OPCODE_LREM            = (byte)113;
    public static final byte INSTRUCTION_OPCODE_FREM            = (byte)114;
    public static final byte INSTRUCTION_OPCODE_DREM            = (byte)115;
    public static final byte INSTRUCTION_OPCODE_INEG            = (byte)116;
    public static final byte INSTRUCTION_OPCODE_LNEG            = (byte)117;
    public static final byte INSTRUCTION_OPCODE_FNEG            = (byte)118;
    public static final byte INSTRUCTION_OPCODE_DNEG            = (byte)119;
    public static final byte INSTRUCTION_OPCODE_ISHL            = (byte)120;
    public static final byte INSTRUCTION_OPCODE_LSHL            = (byte)121;
    public static final byte INSTRUCTION_OPCODE_ISHR            = (byte)122;
    public static final byte INSTRUCTION_OPCODE_LSHR            = (byte)123;
    public static final byte INSTRUCTION_OPCODE_IUSHR           = (byte)124;
    public static final byte INSTRUCTION_OPCODE_LUSHR           = (byte)125;
    public static final byte INSTRUCTION_OPCODE_IAND            = (byte)126;
    public static final byte INSTRUCTION_OPCODE_LAND            = (byte)127;
    public static final byte INSTRUCTION_OPCODE_IOR             = (byte)128;
    public static final byte INSTRUCTION_OPCODE_LOR             = (byte)129;
    public static final byte INSTRUCTION_OPCODE_IXOR            = (byte)130;
    public static final byte INSTRUCTION_OPCODE_LXOR            = (byte)131;
    public static final byte INSTRUCTION_OPCODE_IINC            = (byte)132;
    public static final byte INSTRUCTION_OPCODE_I2L             = (byte)133;
    public static final byte INSTRUCTION_OPCODE_I2F             = (byte)134;
    public static final byte INSTRUCTION_OPCODE_I2D             = (byte)135;
    public static final byte INSTRUCTION_OPCODE_L2I             = (byte)136;
    public static final byte INSTRUCTION_OPCODE_L2F             = (byte)137;
    public static final byte INSTRUCTION_OPCODE_L2D             = (byte)138;
    public static final byte INSTRUCTION_OPCODE_F2I             = (byte)139;
    public static final byte INSTRUCTION_OPCODE_F2L             = (byte)140;
    public static final byte INSTRUCTION_OPCODE_F2D             = (byte)141;
    public static final byte INSTRUCTION_OPCODE_D2I             = (byte)142;
    public static final byte INSTRUCTION_OPCODE_D2L             = (byte)143;
    public static final byte INSTRUCTION_OPCODE_D2F             = (byte)144;
    public static final byte INSTRUCTION_OPCODE_I2B             = (byte)145;
    public static final byte INSTRUCTION_OPCODE_I2C             = (byte)146;
    public static final byte INSTRUCTION_OPCODE_I2S             = (byte)147;
    public static final byte INSTRUCTION_OPCODE_LCMP            = (byte)148;
    public static final byte INSTRUCTION_OPCODE_FCMPL           = (byte)149;
    public static final byte INSTRUCTION_OPCODE_FCMPG           = (byte)150;
    public static final byte INSTRUCTION_OPCODE_DCMPL           = (byte)151;
    public static final byte INSTRUCTION_OPCODE_DCMPG           = (byte)152;
    public static final byte INSTRUCTION_OPCODE_IFEQ            = (byte)153;
    public static final byte INSTRUCTION_OPCODE_IFNE            = (byte)154;
    public static final byte INSTRUCTION_OPCODE_IFLT            = (byte)155;
    public static final byte INSTRUCTION_OPCODE_IFGE            = (byte)156;
    public static final byte INSTRUCTION_OPCODE_IFGT            = (byte)157;
    public static final byte INSTRUCTION_OPCODE_IFLE            = (byte)158;
    public static final byte INSTRUCTION_OPCODE_IF_ICMPEQ       = (byte)159;
    public static final byte INSTRUCTION_OPCODE_IF_ICMPNE       = (byte)160;
    public static final byte INSTRUCTION_OPCODE_IF_ICMPLT       = (byte)161;
    public static final byte INSTRUCTION_OPCODE_IF_ICMPGE       = (byte)162;
    public static final byte INSTRUCTION_OPCODE_IF_ICMPGT       = (byte)163;
    public static final byte INSTRUCTION_OPCODE_IF_ICMPLE       = (byte)164;
    public static final byte INSTRUCTION_OPCODE_IF_ACMPEQ       = (byte)165;
    public static final byte INSTRUCTION_OPCODE_IF_ACMPNE       = (byte)166;
    public static final byte INSTRUCTION_OPCODE_GOTO            = (byte)167 ;
    public static final byte INSTRUCTION_OPCODE_JSR             = (byte)168;
    public static final byte INSTRUCTION_OPCODE_RET             = (byte)169;
    public static final byte INSTRUCTION_OPCODE_TABLESWITCH     = (byte)170;
    public static final byte INSTRUCTION_OPCODE_LOOKUPSWITCH    = (byte)171;
    public static final byte INSTRUCTION_OPCODE_IRETURN         = (byte)172;
    public static final byte INSTRUCTION_OPCODE_LRETURN         = (byte)173;
    public static final byte INSTRUCTION_OPCODE_FRETURN         = (byte)174;
    public static final byte INSTRUCTION_OPCODE_DRETURN         = (byte)175;
    public static final byte INSTRUCTION_OPCODE_ARETURN         = (byte)176;
    public static final byte INSTRUCTION_OPCODE_RETURN          = (byte)177;
    public static final byte INSTRUCTION_OPCODE_GETSTATIC       = (byte)178;
    public static final byte INSTRUCTION_OPCODE_PUTSTATIC       = (byte)179;
    public static final byte INSTRUCTION_OPCODE_GETFIELD        = (byte)180;
    public static final byte INSTRUCTION_OPCODE_PUTFIELD        = (byte)181;
    public static final byte INSTRUCTION_OPCODE_INVOKEVIRTUAL   = (byte)182;
    public static final byte INSTRUCTION_OPCODE_INVOKESPECIAL   = (byte)183;
    public static final byte INSTRUCTION_OPCODE_INVOKESTATIC    = (byte)184;
    public static final byte INSTRUCTION_OPCODE_INVOKEINTERFACE = (byte)185;
    public static final byte INSTRUCTION_OPCODE_INVOKEDYNAMIC   = (byte)186;
    public static final byte INSTRUCTION_OPCODE_NEW              = (byte)187;
    public static final byte INSTRUCTION_OPCODE_NEWARRAY        = (byte)188;
    public static final byte INSTRUCTION_OPCODE_ANEWARRAY       = (byte)189;
    public static final byte INSTRUCTION_OPCODE_ARRAYLENGTH     = (byte)190;
    public static final byte INSTRUCTION_OPCODE_ATHROW          = (byte)191;
    public static final byte INSTRUCTION_OPCODE_CHECKCAST       = (byte)192;
    public static final byte INSTRUCTION_OPCODE_INSTANCEOF      = (byte)193;
    public static final byte INSTRUCTION_OPCODE_MONITORENTER    = (byte)194;
    public static final byte INSTRUCTION_OPCODE_MONITOREXIT     = (byte)195;
    public static final byte INSTRUCTION_OPCODE_WIDE            = (byte)196;
    public static final byte INSTRUCTION_OPCODE_MULTIANEWARRAY  = (byte)197;
    public static final byte INSTRUCTION_OPCODE_IFNULL          = (byte)198;
    public static final byte INSTRUCTION_OPCODE_IFNONNULL       = (byte)199;
    public static final byte INSTRUCTION_OPCODE_GOTO_W          = (byte)200;
    public static final byte INSTRUCTION_OPCODE_JSR_W           = (byte)201;
    public static final byte INSTRUCTION_OPCODE_BREAKPOINT      = (byte)202;
    public static final byte INSTRUCTION_OPCODE_IMPDEP1         = (byte)254;
    public static final byte INSTRUCTION_OPCODE_IMPDEP2          = (byte)255;




    public static final char ELEMENT_VALUE_STRING_CONSTANT = 's';
    public static final char ELEMENT_VALUE_ENUM_CONSTANT   = 'e';
    public static final char ELEMENT_VALUE_CLASS           = 'c';
    public static final char ELEMENT_VALUE_ANNOTATION      = '@';
    public static final char ELEMENT_VALUE_ARRAY           = '[';

    public static final char PACKAGE_SEPARATOR        = '/';
    public static final char INNER_CLASS_SEPARATOR    = '$';
    public static final char SPECIAL_CLASS_CHARACTER  = '-';
    public static final char SPECIAL_MEMBER_SEPARATOR = '$';

    public static final char METHOD_ARGUMENTS_OPEN  = '(';
    public static final char METHOD_ARGUMENTS_CLOSE = ')';

    public static final String METHOD_NAME_INIT   = "<init>";
    public static final String METHOD_TYPE_INIT   = "()V";
    public static final String METHOD_NAME_CLINIT = "<clinit>";
    public static final String METHOD_TYPE_CLINIT = "()V";

    public static final char TYPE_VOID                   = 'V';
    public static final char TYPE_BOOLEAN                = 'Z';
    public static final char TYPE_BYTE                   = 'B';
    public static final char TYPE_CHAR                   = 'C';
    public static final char TYPE_SHORT                  = 'S';
    public static final char TYPE_INT                    = 'I';
    public static final char TYPE_LONG                   = 'J';
    public static final char TYPE_FLOAT                  = 'F';
    public static final char TYPE_DOUBLE                 = 'D';
    public static final char TYPE_CLASS_START            = 'L';
    public static final char TYPE_CLASS_END              = ';';
    public static final char TYPE_ARRAY                  = '[';
    public static final char TYPE_GENERIC_VARIABLE_START = 'T';
    public static final char TYPE_GENERIC_START          = '<';
    public static final char TYPE_GENERIC_BOUND          = ':';
    public static final char TYPE_GENERIC_END            = '>';

    public static final int TYPICAL_CONSTANT_POOL_SIZE       = 256;
    public static final int TYPICAL_FIELD_COUNT              = 64;
    public static final int TYPICAL_METHOD_COUNT             = 64;
    public static final int TYPICAL_CODE_LENGTH              = 1024;
    public static final int TYPICAL_LINE_NUMBER_TABLE_LENGTH = 1024;
    public static final int TYPICAL_EXCEPTION_TABLE_LENGTH   = 16;
    public static final int TYPICAL_VARIABLES_SIZE           = 64;
    public static final int TYPICAL_STACK_SIZE               = 16;
}
