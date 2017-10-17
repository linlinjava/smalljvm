package smalljvm.classfile.constant;

import smalljvm.classfile.ConstantInfo;

/**
 * Created by junling on 2017/4/6.
 */
public class InvokeDynamicConstant implements ConstantInfo {
    public byte tag;
    public short bootstrap_method_attr_index;
    public short name_and_type_index;

    public static final int LENGTH = 5;

    public byte tag (){
        return tag;
    }

    @Override
    public String toString(){
        return "InvokeDynamicConstant bootstrap_method_attr_index=" + String.valueOf(bootstrap_method_attr_index) + " name_and_type_index=" + String.valueOf(name_and_type_index);
    }
}
