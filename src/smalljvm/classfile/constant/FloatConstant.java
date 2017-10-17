package smalljvm.classfile.constant;

import smalljvm.classfile.ConstantInfo;

/**
 * Created by junling on 2017/4/6.
 */
public class FloatConstant implements ConstantInfo {
    public byte tag;
    public float floatValue;

    public static final int LENGTH = 5;

    public byte tag (){
        return tag;
    }

    @Override
    public String toString(){
        return "FloatConstant value=" + String.valueOf(floatValue);
    }

    public float value() {
        return floatValue;
    }
}
