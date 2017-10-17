package smalljvm.classfile;

import smalljvm.classfile.attribute.CodeAttribute;

/**
 * Created by junling on 2017/4/6.
 */
public class MethodInfo {
    public short access_flags;
    public short name_index;
    public short descriptor_index;
    public short attributes_count;
    public AttributeInfo[] attributes;

    private ClassFile clazz = null;
    protected MethodInfo(ClassFile aClass) {
        clazz = aClass;
    }

    @Override
    public String toString() {
        return "MethodInfo" +
                " access_flags=" + Integer.toHexString(access_flags) +
                " name_index= " + String.valueOf(name_index) +
                " descriptor_index= " + String.valueOf(descriptor_index) +
                " attributes_count " + String.valueOf(attributes_count) +
                " attributes=" + attributes;
    }

    public String getName() {
        return clazz.getUtf(name_index);
    }

    public String getDescriptor() {
        return clazz.getUtf(descriptor_index);
    }

    public CodeAttribute codeAttribute(){
        for(short i = 0; i < attributes_count; i++)
        {
            AttributeInfo attribute = attributes[i];
            short index = attribute.nameindex();
            String attribute_name = clazz.getUtf(index);
            if (!attribute_name.equals(Env.ATTRIBUTE_NAME_Code))
                continue;

            CodeAttribute codes = (CodeAttribute)attribute;
            return codes;
        }
        return null;
    }

    public short getAccessFlags() {
        return access_flags;
    }
}
