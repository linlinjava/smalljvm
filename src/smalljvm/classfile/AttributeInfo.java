package smalljvm.classfile;


/**
 * Created by junling on 2017/4/6.
 */
public interface AttributeInfo {

    int length();

    short nameindex();

    public static boolean isBootstrapMethods(ClassFile clazz, AttributeInfo attribute){ return (clazz.getString(attribute.nameindex()) == Env.ATTRIBUTE_NAME_BootstrapMethods); }
    public static boolean isSourceFile(ClassFile clazz, AttributeInfo attribute){ return (clazz.getString(attribute.nameindex()) == Env.ATTRIBUTE_NAME_SourceFile); }
    public static boolean isSourceDebugExtension(ClassFile clazz, AttributeInfo attribute){ return (clazz.getString(attribute.nameindex()) == Env.ATTRIBUTE_NAME_SourceDebugExtension); }
    public static boolean isInnerClasses(ClassFile clazz, AttributeInfo attribute){ return (clazz.getString(attribute.nameindex()) == Env.ATTRIBUTE_NAME_InnerClasses); }
    public static boolean isEnclosingMethod(ClassFile clazz, AttributeInfo attribute){ return (clazz.getString(attribute.nameindex()) == Env.ATTRIBUTE_NAME_EnclosingMethod); }
    public static boolean isDeprecated(ClassFile clazz, AttributeInfo attribute){ return (clazz.getString(attribute.nameindex()) == Env.ATTRIBUTE_NAME_Deprecated); }
    public static boolean isSynthetic(ClassFile clazz, AttributeInfo attribute){ return (clazz.getString(attribute.nameindex()) == Env.ATTRIBUTE_NAME_Synthetic); }
    public static boolean isSignature(ClassFile clazz, AttributeInfo attribute){ return (clazz.getString(attribute.nameindex()) == Env.ATTRIBUTE_NAME_Signature); }
    public static boolean isConstantValue(ClassFile clazz, AttributeInfo attribute){ return (clazz.getString(attribute.nameindex()) == Env.ATTRIBUTE_NAME_ConstantValue); }
    public static boolean isMethodParameters(ClassFile clazz, AttributeInfo attribute){ return (clazz.getString(attribute.nameindex()) == Env.ATTRIBUTE_NAME_MethodParameters); }
    public static boolean isExceptions(ClassFile clazz, AttributeInfo attribute){ return (clazz.getString(attribute.nameindex()) == Env.ATTRIBUTE_NAME_Exceptions); }
    public static boolean isCode(ClassFile clazz, AttributeInfo attribute){ return (clazz.getString(attribute.nameindex()) == Env.ATTRIBUTE_NAME_Code); }
    public static boolean isStackMapTable(ClassFile clazz, AttributeInfo attribute){ return (clazz.getString(attribute.nameindex()) == Env.ATTRIBUTE_NAME_StackMapTable); }
    public static boolean isLineNumberTable(ClassFile clazz, AttributeInfo attribute){ return (clazz.getString(attribute.nameindex()) == Env.ATTRIBUTE_NAME_LineNumberTable); }
    public static boolean isLocalVariableTable(ClassFile clazz, AttributeInfo attribute){ return (clazz.getString(attribute.nameindex()) == Env.ATTRIBUTE_NAME_LocalVariableTable); }
    public static boolean isRuntimeVisibleAnnotations(ClassFile clazz, AttributeInfo attribute){ return (clazz.getString(attribute.nameindex()) == Env.ATTRIBUTE_NAME_RuntimeVisibleAnnotations); }
    public static boolean isRuntimeInvisibleAnnotations(ClassFile clazz, AttributeInfo attribute){ return (clazz.getString(attribute.nameindex()) == Env.ATTRIBUTE_NAME_RuntimeInvisibleAnnotations); }
    public static boolean isRuntimeVisibleParameterAnnotations(ClassFile clazz, AttributeInfo attribute){ return (clazz.getString(attribute.nameindex()) == Env.ATTRIBUTE_NAME_RuntimeVisibleParameterAnnotations); }
    public static boolean isRuntimeInvisibleParameterAnnotations(ClassFile clazz, AttributeInfo attribute){ return (clazz.getString(attribute.nameindex()) == Env.ATTRIBUTE_NAME_RuntimeInvisibleParameterAnnotations); }
    public static boolean isRuntimeVisibleTypeAnnotations(ClassFile clazz, AttributeInfo attribute){ return (clazz.getString(attribute.nameindex()) == Env.ATTRIBUTE_NAME_RuntimeVisibleTypeAnnotations); }
    public static boolean isRuntimeInvisibleTypeAnnotations(ClassFile clazz, AttributeInfo attribute){ return (clazz.getString(attribute.nameindex()) == Env.ATTRIBUTE_NAME_RuntimeInvisibleTypeAnnotations); }
    public static boolean isAnnotationDefault(ClassFile clazz, AttributeInfo attribute){ return (clazz.getString(attribute.nameindex()) == Env.ATTRIBUTE_NAME_AnnotationDefault); }

}
