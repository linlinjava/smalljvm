package smalljvm.classfile.constant;

import smalljvm.classfile.ConstantInfo;

/**
 * Created by junling on 2017/4/6.
 */
public class InterfaceMethodrefConstant implements ConstantInfo {
    public byte tag;
    public short class_index;
    public short name_and_type_index;

    public static final int LENGTH = 5;

    public byte tag (){
        return tag;
    }

    @Override
    public String toString(){
        return "InterfaceMethodrefConstant class_index=" + String.valueOf(class_index) + " name_and_type_index=" + String.valueOf(name_and_type_index);
    }
}
