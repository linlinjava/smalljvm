package smalljvm.classfile.constant;

import smalljvm.classfile.ConstantInfo;

/**
 * Created by junling on 2017/4/6.
 */
public class Utf8Constant implements ConstantInfo {
    public byte tag;
    public short length;
    public byte[] bytes;

    public byte tag (){
        return tag;
    }

    public byte[] value (){
        return bytes;
    }

    public String string() { return new String(bytes); }

    @Override
    public String toString(){
        return "Utf8Constant length=" + String.valueOf(length) + " content=" + new String(bytes);
    }
}
