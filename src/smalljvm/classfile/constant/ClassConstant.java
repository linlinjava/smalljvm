package smalljvm.classfile.constant;

import smalljvm.classfile.ConstantInfo;

/**
 * Created by junling on 2017/4/6.
 */
public class ClassConstant implements ConstantInfo {
    public byte tag;
    public short name_index;

    public static final int LENGTH = 3;

    public byte tag (){
        return tag;
    }

    @Override
    public String toString(){
        return "ClassConstant name_index=" + String.valueOf(name_index);
    }

}
