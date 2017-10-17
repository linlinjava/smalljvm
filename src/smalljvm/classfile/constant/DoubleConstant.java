package smalljvm.classfile.constant;

import smalljvm.classfile.ConstantInfo;

/**
 * Created by junling on 2017/4/6.
 */
public class DoubleConstant implements ConstantInfo {
    public byte tag;
    public double doubleValue;

    public static final int LENGTH = 7;

    public byte tag (){
        return tag;
    }

    public double value (){
        return doubleValue;
    }

    @Override
    public String toString(){
        return "DoubleConstant value=" + String.valueOf(doubleValue);
    }

}
