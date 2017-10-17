package smalljvm.classfile.attribute;

import smalljvm.classfile.AttributeInfo;

/**
 * Created by junling on 2017/4/6.
 */
public class InnerClassesAttribute implements AttributeInfo {
    public short attribute_name_index;
    public int attribute_length;
    public short number_of_classes;
    public InnerClassInfo[] classes;

    @Override
    public int length() {
        return attribute_length;
    }

    @Override
    public short nameindex() {
        return attribute_name_index;
    }



}
