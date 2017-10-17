package smalljvm.classfile.constant;

import smalljvm.classfile.ConstantInfo;

/**
 * Created by junling on 2017/4/6.
 */
public class IntegerConstant implements ConstantInfo {
    public byte tag;
    public int intValue;

    public static final int LENGTH = 5;

    public byte tag (){
        return tag;
    }

    public int value () {
        return intValue;
    }

    @Override
    public String toString(){
        return "IntegerConstant value=" + String.valueOf(intValue);
    }
}
