package smalljvm.classfile.attribute.annotation;

import smalljvm.classfile.AttributeInfo;

/**
 * Created by junling on 2017/4/6.
 */
public class RuntimeVisibleParameterAnnotationAttribute implements AttributeInfo {
    public short attribute_name_index;
    public int attribute_length;
    public byte num_parameters;
    public ParameterAnnotation[] parameter_annotations;
;

    @Override
    public int length() {
        return attribute_length;
    }

    @Override
    public short nameindex() {
        return attribute_name_index;
    }

    class ParameterAnnotation {
        public short num_annotations;
        public RuntimeVisibleAnnotationsAttribute.Annotation annotations;
    }

}
