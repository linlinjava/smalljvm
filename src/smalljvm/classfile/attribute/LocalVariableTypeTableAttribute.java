package smalljvm.classfile.attribute;

import smalljvm.classfile.AttributeInfo;

/**
 * Created by junling on 2017/4/6.
 */
public class LocalVariableTypeTableAttribute implements AttributeInfo {
    public short attribute_name_index;
    public int attribute_length;
;   public short local_variable_type_table_length;
    public LocalVariableTypeInfo[] local_variable_type_table;

    @Override
    public int length() {
        return attribute_length;
    }

    @Override
    public short nameindex() {
        return attribute_name_index;
    }


}
