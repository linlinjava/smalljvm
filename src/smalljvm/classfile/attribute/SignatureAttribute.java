package smalljvm.classfile.attribute;

import smalljvm.classfile.AttributeInfo;

/**
 * Created by junling on 2017/4/6.
 */
public class SignatureAttribute implements AttributeInfo {
    public short attribute_name_index;
    public int attribute_length;
    public short signature_index;
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
