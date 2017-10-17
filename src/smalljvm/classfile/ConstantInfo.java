package smalljvm.classfile;

/**
 * Created by junling on 2017/4/6.
 */
public interface ConstantInfo {

    byte tag ();

    public static boolean isClass(ConstantInfo constant){ return (constant.tag() == Env.TAG_CONSTANT_Class); }
    public static boolean isFieldRef(ConstantInfo constant){ return (constant.tag() == Env.TAG_CONSTANT_Fieldref); }
    public static boolean isMethodref(ConstantInfo constant){ return (constant.tag() == Env.TAG_CONSTANT_Methodref); }
    public static boolean isInterfaceMethodref(ConstantInfo constant){ return (constant.tag() == Env.TAG_CONSTANT_InterfaceMethodref); }
    public static boolean isString(ConstantInfo constant){
        return (constant.tag() == Env.TAG_CONSTANT_String);
    }
    public static boolean isInteger(ConstantInfo constant){
        return (constant.tag() == Env.TAG_CONSTANT_Integer);
    }
    public static boolean isFloat(ConstantInfo constant){
        return (constant.tag() == Env.TAG_CONSTANT_Float);
    }
    public static boolean isLong(ConstantInfo constant){
        return (constant.tag() == Env.TAG_CONSTANT_Long);
    }
    public static boolean isDouble(ConstantInfo constant){
        return (constant.tag() == Env.TAG_CONSTANT_Double);
    }
    public static boolean isNameAndType(ConstantInfo constant){
        return (constant.tag() == Env.TAG_CONSTANT_NameAndType);
    }
    public static boolean isUtf8(ConstantInfo constant){
        return (constant.tag() == Env.TAG_CONSTANT_Utf8);
    }
    public static boolean isMethodHandle(ConstantInfo constant){ return (constant.tag() == Env.TAG_CONSTANT_MethodHandle); }
    public static boolean isMethodType(ConstantInfo constant){
        return (constant.tag() == Env.TAG_CONSTANT_MethodType);
    }
    public static boolean isInvokeDynamic(ConstantInfo constant){ return (constant.tag() == Env.TAG_CONSTANT_InvokeDynamic); }

}
