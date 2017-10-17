package smalljvm.classfile;

/**
 * Created by junling on 2017/4/6.
 */
public class FieldInfo {
    public short access_flags;
    public short name_index;
    public short descriptor_index;
    public short attributes_count;
    public AttributeInfo[] attributes;

    private ClassFile clazz = null;
    protected FieldInfo(ClassFile aClass) {
        clazz = aClass;
    }

    @Override
    public String toString() {
        return "FieldInfo" +
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

    public short getAccessFlags() {
        return access_flags;
    }
}
