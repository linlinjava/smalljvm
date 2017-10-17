package smalljvm.classfile;


import smalljvm.classfile.constant.ClassConstant;
import smalljvm.classfile.constant.StringConstant;
import smalljvm.classfile.constant.Utf8Constant;

/**
 * Created by junling on 2017/4/6.
 */
public class ClassFile {
    public int magic;
    public short minor_version;
    public short major_version;
    public short constant_pool_count;
    public ConstantInfo[] constant_pool = new ConstantInfo[0];
    public short access_flags;
    public short this_class;
    public short super_class;
    public short interfaces_count;
    public short[] interfaces = new short[0];
    public short fields_count;
    public FieldInfo[] fields = new FieldInfo[0];
    public short methods_count;
    public MethodInfo[] methods = new MethodInfo[0];
    public short attributes_count;
    public AttributeInfo[] attributes = new AttributeInfo[0];



    @Override
    public String toString(){
        String s = "ClassFile";
        s += "magic " + Integer.toHexString(magic) + "\n";
        s += "minor_version " + String.valueOf(minor_version) + "\n";
        s += "major_version " + String.valueOf(major_version) + "\n";

        s += "constant_pool_count " + String.valueOf(constant_pool_count) + "\n";
        for(int i = 0; i < constant_pool_count; i++){
            ConstantInfo constant = constant_pool[i];
            if (constant != null)
            s += "constant[" + String.valueOf(i) + "]: " + constant.toString() + "\n";
        }

        s += "access_flags " + String.valueOf(access_flags) + "\n";
        s += "this_class " + String.valueOf(this_class) + "\n";
        s += "super_class " + String.valueOf(super_class) + "\n";

        s += "interfaces_count " + String.valueOf(interfaces_count) + "\n";
        for(int i = 0; i < interfaces_count; i++){
            s += "interfaces[" + String.valueOf(i) + "]: " + interfaces[i] + "\n";
        }

        s += "fields_count " + String.valueOf(fields_count) + "\n";
        for(int i = 0; i < fields_count; i++){
            FieldInfo field = fields[i];
            s += "fields[" + String.valueOf(i) + "]:";
            s += field.toString();
            s += "\n";
        }

        s += "methods_count " + String.valueOf(methods_count) + "\n";
        for(int i = 0; i < methods_count; i++){
            MethodInfo method = methods[i];
            s += "methods[" + String.valueOf(i) + "]: ";
            s += method.toString();
            s += "\n";
        }

        s += "attributes_count " + String.valueOf(attributes_count) + "\n";
        for(int i = 0; i < attributes_count; i++){
            AttributeInfo attribute = attributes[i];
            s += "attributes[" + String.valueOf(i) + "]:";
            s += attribute.toString();
            s += "\n";
        }

        return s;
    }

    public String getName() {
        return getClassName(this_class);
    }

    public String getSuperName() {
        if (super_class == 0){
            if(!getName().equals("java/lang/Object"))
                throw new IllegalStateException("");
            return null;
        }

        return getClassName(super_class);
    }

    public short getInterfacesCount(){
        return interfaces_count;
    }
    public String getInterfaceName(short index){
        return getClassName(interfaces[index]);
    }




    public FieldInfo findField(String name, String descriptor)
    {
        for (int index = 0; index < fields_count; index++)
        {
            FieldInfo field = fields[index];
            if ((name == null || field.getName().equals(name)) &&
                    (descriptor == null || field.getDescriptor().equals(descriptor)))
            {
                return field;
            }
        }

        return null;
    }



    public MethodInfo findMethod(String name, String descriptor)
    {
        for (int index = 0; index < methods_count; index++)
        {
            MethodInfo method = methods[index];
            if ((name == null || method.getName().equals(name)) &&
                    (descriptor == null || method.getDescriptor().equals(descriptor)))
            {
                return method;
            }
        }

        return null;
    }

    public String getClassName(short index){
        ConstantInfo constant = constant_pool[index];
        if (!ConstantInfo.isClass(constant))
            throw new IllegalStateException("");

        ClassConstant classConstant = (ClassConstant)constant;
        short name_index = classConstant.name_index;

        constant = constant_pool[name_index];
        if (!ConstantInfo.isUtf8(constant))
            throw new IllegalStateException("");

        Utf8Constant utf8Constant = (Utf8Constant)constant;
        return utf8Constant.string();
    }

    public String getUtf(short index){
        ConstantInfo constant = constant_pool[index];
        if (!ConstantInfo.isUtf8(constant))
            throw new IllegalStateException("");

        Utf8Constant utf8Constant = (Utf8Constant)constant;
        return utf8Constant.string();
    }

    public String getString(short index){
        ConstantInfo constant = constant_pool[index];
        if (!ConstantInfo.isString(constant))
            throw new IllegalStateException("");

        StringConstant stringConstant = (StringConstant)constant;
        short name_index = stringConstant.string_index;

        constant = constant_pool[name_index];
        if (!ConstantInfo.isUtf8(constant))
            throw new IllegalStateException("");

        Utf8Constant utf8Constant = (Utf8Constant)constant;
        return utf8Constant.string();
    }

}
