package smalljvm.classfile.attribute;

import smalljvm.classfile.AttributeInfo;

/**
 * Created by junling on 2017/4/6.
 */
public class EnclosingMethodAttribute implements AttributeInfo {
    public short attribute_name_index;
    public int attribute_length;
    public short class_index;
    public short method_index;

    @Override
    public int length() {
        return attribute_length;
    }

    @Override
    public short nameindex() {
        return attribute_name_index;
    }
}
