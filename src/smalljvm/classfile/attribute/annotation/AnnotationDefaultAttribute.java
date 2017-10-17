package smalljvm.classfile.attribute.annotation;

import smalljvm.classfile.AttributeInfo;

/**
 * Created by junling on 2017/4/6.
 */
public class AnnotationDefaultAttribute implements AttributeInfo {
    public short attribute_name_index;
    public int attribute_length;
;   public RuntimeVisibleAnnotationsAttribute.ElementValue default_value;
    public static final int LENGTH = 0;

    @Override
    public int length() {
        return attribute_length;
    }

    @Override
    public short nameindex() {
        return attribute_name_index;
    }
}
