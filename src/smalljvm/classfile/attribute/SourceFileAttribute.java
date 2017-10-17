package smalljvm.classfile.attribute;

import smalljvm.classfile.AttributeInfo;

/**
 * Created by junling on 2017/4/6.
 */
public class SourceFileAttribute implements AttributeInfo {
    public short attribute_name_index;
    public int attribute_length;
    public int sourcefile_index;
;

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
        return "SourceFileAttribute" +
                " attribute_name_index=" + attribute_name_index +
                " attribute_length=" + attribute_length +
                " sourcefile_index=" + sourcefile_index;
    }
}
