package smalljvm.classfile.constant;

import smalljvm.classfile.ConstantInfo;

/**
 * Created by junling on 2017/4/6.
 */
public class MethodTypeConstant implements ConstantInfo {
    public byte tag;
    public short descriptor_index;
    public static final int LENGTH = 3;

    public byte tag (){
        return tag;
    }

    public short index(){
        return descriptor_index;
    }

    @Override
    public String toString(){
        return "MethodTypeConstant descriptor_index=" + String.valueOf(descriptor_index);
    }
}
