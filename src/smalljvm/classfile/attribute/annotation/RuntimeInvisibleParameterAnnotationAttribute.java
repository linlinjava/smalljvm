package smalljvm.classfile.attribute.annotation;

import smalljvm.classfile.AttributeInfo;

/**
 * Created by junling on 2017/4/6.
 */
public class RuntimeInvisibleParameterAnnotationAttribute implements AttributeInfo {
    public short attribute_name_index;
    public int attribute_length;
    public byte num_parameters;
    public RuntimeVisibleParameterAnnotationAttribute.ParameterAnnotation[] parameter_annotations;
;

    @Override
    public int length() {
        return attribute_length;
    }

    @Override
    public short nameindex() {
        return attribute_name_index;
    }

}
