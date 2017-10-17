package smalljvm.classfile.constant;

import smalljvm.classfile.ConstantInfo;

/**
 * Created by junling on 2017/4/6.
 */
public class NameAndTypeConstant implements ConstantInfo {
    public byte tag;
    public short name_index;
    public short descriptor_index;
    public static final int LENGTH = 5;

    public byte tag (){
        return tag;
    }

    @Override
    public String toString(){
        return "NameAndTypeConstant name_index=" + String.valueOf(name_index) + " descriptor_index=" + String.valueOf(descriptor_index);
    }
}
