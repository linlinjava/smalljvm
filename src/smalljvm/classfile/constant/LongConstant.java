package smalljvm.classfile.constant;

import smalljvm.classfile.ConstantInfo;

/**
 * Created by junling on 2017/4/6.
 */
public class LongConstant implements ConstantInfo {
    public byte tag;
    public long longValue;

    public static final int LENGTH = 9;

    public byte tag (){
        return tag;
    }

    public long value () {
        return longValue;
    }

    @Override
    public String toString(){
        return "LongConstant value=" + String.valueOf(longValue);
    }
}
