package smalljvm.classfile.constant;

import smalljvm.classfile.ConstantInfo;

/**
 * Created by junling on 2017/4/6.
 */
public class MethodHandleConstant implements ConstantInfo {
    public byte tag;
    public byte reference_kind;
    public short reference_index;
    public static final int LENGTH = 4;

    public byte tag (){
        return tag;
    }

    @Override
    public String toString(){
        return "MethodHandleConstant reference_kind=" + String.valueOf(reference_kind) + " reference_index=" + String.valueOf(reference_index);
    }
}
