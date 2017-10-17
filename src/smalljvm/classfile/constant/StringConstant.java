package smalljvm.classfile.constant;

import smalljvm.classfile.ConstantInfo;

/**
 * Created by junling on 2017/4/6.
 */
public class StringConstant implements ConstantInfo {
    public byte tag;
    public short string_index;
    public static final int LENGTH = 3;

    public byte tag (){
        return tag;
    }

    public short index(){
        return string_index;
    }

    @Override
    public String toString(){
        return "StringConstant string_index=" + String.valueOf(string_index);
    }
}
