package smalljvm.classfile.attribute;

import smalljvm.classfile.AttributeInfo;

/**
 * Created by junling on 2017/4/6.
 */
public class ExceptionsAttribute implements AttributeInfo {
    public short attribute_name_index;
    public int attribute_length;
    public short number_of_execeptions;
    public short[] exception_index_table;

    @Override
    public int length() {
        return attribute_length;
    }

    @Override
    public short nameindex() {
        return attribute_name_index;
    }
}
