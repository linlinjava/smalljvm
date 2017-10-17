package smalljvm.classfile.attribute;

import smalljvm.classfile.AttributeInfo;

/**
 * Created by junling on 2017/4/6.
 */
public class CodeAttribute implements AttributeInfo {
    public short attribute_name_index;
    public int attribute_length;
    public short max_stack;
    public short max_locals;
    public int code_length;
    public byte[] code;
    public short exception_table_length;
    public ExceptionInfo[] exception_table;
    public short attributes_count;
    public AttributeInfo[] attributes;

    @Override
    public int length() {
        return attribute_length;
    }

    @Override
    public short nameindex() {
        return attribute_name_index;
    }


    @Override
    public String toString() {
        return "CodeAttribute" +
                " attribute_name_index=" + attribute_name_index +
                " attribute_length=" + attribute_length +
                " max_stack=" + max_stack +
                " max_locals=" + max_locals +
                " code_length=" + code_length +
                " code=" + code +
                " exception_table_length=" + exception_table_length +
                " exception_table=" + exception_table +
                " attributes_count=" + attributes_count +
                " attributes" + attributes;
    }
}
