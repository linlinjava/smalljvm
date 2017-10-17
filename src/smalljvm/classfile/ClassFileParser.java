package smalljvm.classfile;

import smalljvm.classfile.attribute.*;
import smalljvm.classfile.attribute.annotation.*;
import smalljvm.classfile.constant.*;

import java.io.DataInput;
import java.io.IOException;

import static smalljvm.classfile.Env.*;
import static smalljvm.classfile.Env.TAG_CONSTANT_InvokeDynamic;

public class ClassFileParser {

    public ClassFile parse (DataInput reader) throws IOException {
        if(reader == null)
            return null;

        ClassFile clazz = new ClassFile();

        clazz.magic = reader.readInt();
        clazz.minor_version = reader.readShort();
        clazz.major_version = reader.readShort();

        clazz.constant_pool_count = reader.readShort();
        clazz.constant_pool = new ConstantInfo[clazz.constant_pool_count];
        clazz.constant_pool[0] = null;
        for (short i = 1; i != clazz.constant_pool_count; i++) {
            ConstantInfo constant = parseConstant(reader);

            clazz.constant_pool[i] = constant;

            if (ConstantInfo.isDouble(constant) || ConstantInfo.isLong(constant)) {
                i++;
                clazz.constant_pool[i] = null;
            }
        }
        clazz.access_flags = reader.readShort();

        clazz.this_class = reader.readShort();
        clazz.super_class = reader.readShort();

        clazz.interfaces_count = reader.readShort();
        clazz.interfaces = new short[clazz.interfaces_count];
        for (short i = 0; i != clazz.interfaces_count; i++) {
            clazz.interfaces[i] = reader.readShort();
        }

        clazz.fields_count = reader.readShort();
        clazz.fields = new FieldInfo[clazz.fields_count];
        for (short i = 0; i != clazz.fields_count; i++) {
            clazz.fields[i] = parseField(reader, clazz);
        }

        clazz.methods_count = reader.readShort();
        clazz.methods = new MethodInfo[clazz.methods_count];
        for (short i = 0; i != clazz.methods_count; i++) {
            clazz.methods[i] = parseMethod(reader, clazz);
        }

        clazz.attributes_count = reader.readShort();
        clazz.attributes = new AttributeInfo[clazz.attributes_count];
        for (short i = 0; i != clazz.attributes_count; i++) {
            clazz.attributes[i] = parseAttribute(reader, clazz);
        }

        return clazz;
    }

    private ConstantInfo parseConstant(DataInput reader) throws IOException {

            switch (reader.readByte())
            {
                case TAG_CONSTANT_Class:
                    ClassConstant constantClass = new ClassConstant();
                    constantClass.tag = TAG_CONSTANT_Class;
                    constantClass.name_index = reader.readShort();
                    return constantClass;
                case TAG_CONSTANT_Fieldref:
                    FieldrefConstant constantFieldref = new FieldrefConstant();
                    constantFieldref.tag = TAG_CONSTANT_Fieldref;
                    constantFieldref.class_index = reader.readShort();
                    constantFieldref.name_and_type_index = reader.readShort();
                    return constantFieldref;
                case TAG_CONSTANT_Methodref:
                    MethodrefConstant constantMethodref = new MethodrefConstant();
                    constantMethodref.tag = TAG_CONSTANT_Methodref;
                    constantMethodref.class_index = reader.readShort();
                    constantMethodref.name_and_type_index = reader.readShort();
                    return constantMethodref;
                case TAG_CONSTANT_InterfaceMethodref:
                    InterfaceMethodrefConstant constantInterfaceMethodref = new InterfaceMethodrefConstant();
                    constantInterfaceMethodref.tag = TAG_CONSTANT_InterfaceMethodref;
                    constantInterfaceMethodref.class_index = reader.readShort();
                    constantInterfaceMethodref.name_and_type_index = reader.readShort();
                    return constantInterfaceMethodref;
                case TAG_CONSTANT_String:
                    StringConstant constantString = new StringConstant();
                    constantString.tag = TAG_CONSTANT_String;
                    constantString.string_index = reader.readShort();
                    return constantString;
                case TAG_CONSTANT_Integer:
                    IntegerConstant constantInteger = new IntegerConstant();
                    constantInteger.tag = TAG_CONSTANT_Integer;
                    constantInteger.intValue = reader.readInt();
                    return constantInteger;
                case TAG_CONSTANT_Float:
                    FloatConstant constantFloat = new FloatConstant();
                    constantFloat.tag = TAG_CONSTANT_Float;
                    constantFloat.floatValue = reader.readFloat();
                    return constantFloat;
                case TAG_CONSTANT_Long:
                    LongConstant constantLong = new LongConstant();
                    constantLong.tag = TAG_CONSTANT_Long;
                    constantLong.longValue = reader.readLong();
                    return constantLong;
                case TAG_CONSTANT_Double:
                    DoubleConstant constantDouble = new DoubleConstant();
                    constantDouble.tag = TAG_CONSTANT_Double;
                    constantDouble.doubleValue = reader.readDouble();
                    return constantDouble;
                case TAG_CONSTANT_NameAndType:
                    NameAndTypeConstant constantNameAndType = new NameAndTypeConstant();
                    constantNameAndType.tag = TAG_CONSTANT_NameAndType;
                    constantNameAndType.name_index = reader.readShort();
                    constantNameAndType.descriptor_index = reader.readShort();
                    return constantNameAndType;
                case TAG_CONSTANT_Utf8:
                    Utf8Constant constantUtf8 = new Utf8Constant();
                    constantUtf8.tag = TAG_CONSTANT_Utf8;
                    constantUtf8.length = reader.readShort();
                    constantUtf8.bytes = new byte[constantUtf8.length];
                    reader.readFully(constantUtf8.bytes);
                    return constantUtf8;
                case TAG_CONSTANT_MethodHandle:
                    MethodHandleConstant constantMethodHandle = new MethodHandleConstant();
                    constantMethodHandle.tag = TAG_CONSTANT_MethodHandle;
                    constantMethodHandle.reference_kind = reader.readByte();
                    constantMethodHandle.reference_index = reader.readShort();
                    return constantMethodHandle;
                case TAG_CONSTANT_MethodType:
                    MethodTypeConstant constantMethodType = new MethodTypeConstant();
                    constantMethodType.tag = TAG_CONSTANT_MethodType;
                    constantMethodType.descriptor_index = reader.readShort();
                    return constantMethodType;
                case TAG_CONSTANT_InvokeDynamic:
                    InvokeDynamicConstant constantInvokeDynamic = new InvokeDynamicConstant();
                    constantInvokeDynamic.tag = TAG_CONSTANT_InvokeDynamic;
                    constantInvokeDynamic.bootstrap_method_attr_index = reader.readShort();
                    constantInvokeDynamic.name_and_type_index = reader.readShort();
                    return constantInvokeDynamic;
                default:
                    return null;
            }

    }

    private FieldInfo parseField(DataInput reader, ClassFile clazz) throws IOException {
        FieldInfo field = new FieldInfo(clazz);
        field.access_flags = reader.readShort();
        field.name_index = reader.readShort();
        field.descriptor_index = reader.readShort();

        field.attributes_count = reader.readShort();
        field.attributes = new AttributeInfo[field.attributes_count];
        for (short i = 0; i != field.attributes_count; i++) {
            field.attributes[i] = parseAttribute(reader,clazz);
        }

        return field;
    }

    private MethodInfo parseMethod(DataInput reader, ClassFile clazz) throws IOException {
        MethodInfo method = new MethodInfo(clazz);
        method.access_flags = reader.readShort();
        method.name_index = reader.readShort();
        method.descriptor_index = reader.readShort();

        method.attributes_count = reader.readShort();
        method.attributes = new AttributeInfo[method.attributes_count];
        for (short i = 0; i != method.attributes_count; i++) {
            method.attributes[i] = parseAttribute(reader, clazz);
        }

        return method;
    }

    private AttributeInfo parseAttribute(DataInput reader, ClassFile clazz) throws IOException {

        short attribute_name_index = reader.readShort();
        ConstantInfo constant = clazz.constant_pool[attribute_name_index];
        if (!ConstantInfo.isUtf8(constant))
            throw new IOException();

        Utf8Constant constant_utf8 = (Utf8Constant) constant;
        String attribute_name = new String(constant_utf8.bytes);

        if (attribute_name.equals(Env.ATTRIBUTE_NAME_ConstantValue)) {
            ConstantValueAttribute attribute = new ConstantValueAttribute();
            attribute.attribute_name_index = attribute_name_index;
            attribute.attribute_length = reader.readInt();
            attribute.constantvalue_index = reader.readShort();
            return attribute;
        }

        if (attribute_name.equals(Env.ATTRIBUTE_NAME_Code)) {
            CodeAttribute attribute = new CodeAttribute();
            attribute.attribute_name_index = attribute_name_index;
            attribute.attribute_length = reader.readInt();
            attribute.max_stack = reader.readShort();
            attribute.max_locals = reader.readShort();
            attribute.code_length = reader.readInt();
            attribute.code = new byte[attribute.code_length];
            reader.readFully(attribute.code);
            attribute.exception_table_length = reader.readShort();
            attribute.exception_table = new ExceptionInfo[attribute.exception_table_length];
            for(int i = 0; i < attribute.exception_table_length; i++){
                attribute.exception_table[i] = new ExceptionInfo();
                attribute.exception_table[i].start_pc = reader.readShort();
                attribute.exception_table[i].end_pc = reader.readShort();
                attribute.exception_table[i].handler_pc = reader.readShort();
                attribute.exception_table[i].catch_type = reader.readShort();
            }
            attribute.attributes_count = reader.readShort();
            attribute.attributes = new AttributeInfo[attribute.attributes_count];
            for(int i = 0; i < attribute.attributes_count; i++){
                attribute.attributes[i] = parseAttribute(reader, clazz);
            }
            return attribute;
        }

        if (attribute_name.equals(Env.ATTRIBUTE_NAME_StackMapTable)) {
            StackMapTableAttribute attribute = new StackMapTableAttribute();
            attribute.attribute_name_index = attribute_name_index;
            attribute.attribute_length = reader.readInt();
            attribute.number_of_entries = reader.readShort();

            // REDO
            // currently skip
            reader.skipBytes(attribute.attribute_length - 2);

            return attribute;
        }

        if (attribute_name.equals(Env.ATTRIBUTE_NAME_Exceptions)) {
            ExceptionsAttribute attribute = new ExceptionsAttribute();
            attribute.attribute_name_index = attribute_name_index;
            attribute.attribute_length = reader.readInt();
            attribute.number_of_execeptions = reader.readShort();
            attribute.exception_index_table = new short[attribute.number_of_execeptions];
            for(int i = 0; i < attribute.number_of_execeptions; i++){
                attribute.exception_index_table[i] = reader.readShort();
            }
            return attribute;
        }

        if (attribute_name.equals(Env.ATTRIBUTE_NAME_InnerClasses)) {
            InnerClassesAttribute attribute = new InnerClassesAttribute();
            attribute.attribute_name_index = attribute_name_index;
            attribute.attribute_length = reader.readInt();
            attribute.number_of_classes = reader.readShort();
            attribute.classes = new InnerClassInfo[attribute.number_of_classes];
            for(int i = 0; i < attribute.number_of_classes; i++){
                attribute.classes[i] =  new InnerClassInfo();
                attribute.classes[i].inner_class_info_index = reader.readShort();
                attribute.classes[i].outer_class_info_index = reader.readShort();
                attribute.classes[i].inner_name_index = reader.readShort();
                attribute.classes[i].inner_class_access_flags = reader.readShort();
            }
            return attribute;
        }

        if (attribute_name.equals(Env.ATTRIBUTE_NAME_EnclosingMethod)) {
            EnclosingMethodAttribute attribute = new EnclosingMethodAttribute();
            attribute.attribute_name_index = attribute_name_index;
            attribute.attribute_length = reader.readInt();
            attribute.class_index = reader.readShort();
            attribute.method_index = reader.readShort();
            return attribute;
        }

        if (attribute_name.equals(Env.ATTRIBUTE_NAME_Synthetic)) {
            SyntheticAttribute attribute = new SyntheticAttribute();
            attribute.attribute_name_index = attribute_name_index;
            attribute.attribute_length = reader.readInt();
            return attribute;
        }

        if (attribute_name.equals(Env.ATTRIBUTE_NAME_Signature)) {
            SignatureAttribute attribute = new SignatureAttribute();
            attribute.attribute_name_index = attribute_name_index;
            attribute.attribute_length = reader.readInt();
            attribute.signature_index = reader.readShort();
            return attribute;
        }

        if (attribute_name.equals(Env.ATTRIBUTE_NAME_SourceFile)) {
            SourceFileAttribute attribute = new SourceFileAttribute();
            attribute.attribute_name_index = attribute_name_index;
            attribute.attribute_length = reader.readInt();
            attribute.sourcefile_index = reader.readShort();
            return attribute;
        }

        if (attribute_name.equals(Env.ATTRIBUTE_NAME_SourceDebugExtension)) {
            SourceDebugExtensionAttribute attribute = new SourceDebugExtensionAttribute();
            attribute.attribute_name_index = attribute_name_index;
            attribute.attribute_length = reader.readInt();
            attribute.debug_extension = new byte[attribute.attribute_length];
            reader.readFully(attribute.debug_extension);
            return attribute;
        }

        if (attribute_name.equals(Env.ATTRIBUTE_NAME_LineNumberTable)) {
            LineNumberTableAttribute attribute = new LineNumberTableAttribute();
            attribute.attribute_name_index = attribute_name_index;
            attribute.attribute_length = reader.readInt();
            attribute.line_number_table_length = reader.readShort();
            attribute.line_number_table = new LineNumberInfo[attribute.line_number_table_length];
            for(int i = 0; i < attribute.line_number_table_length; i++){
                attribute.line_number_table[i] = new LineNumberInfo();
                attribute.line_number_table[i].start_pc = reader.readShort();
                attribute.line_number_table[i].line_number = reader.readShort();
            }
            return attribute;
        }

        if (attribute_name.equals(Env.ATTRIBUTE_NAME_LocalVariableTable)) {
            LocalVariableTableAttribute attribute = new LocalVariableTableAttribute();
            attribute.attribute_name_index = attribute_name_index;
            attribute.attribute_length = reader.readInt();
            attribute.local_variable_table_length = reader.readShort();
            attribute.local_variable_table = new LocalVariableInfo[attribute.local_variable_table_length];
            for(int i = 0; i < attribute.local_variable_table_length; i++){
                attribute.local_variable_table[i] = new LocalVariableInfo();
                attribute.local_variable_table[i].start_pc = reader.readShort();
                attribute.local_variable_table[i].length = reader.readShort();
                attribute.local_variable_table[i].name_index = reader.readShort();
                attribute.local_variable_table[i].descriptor_index = reader.readShort();
                attribute.local_variable_table[i].index = reader.readShort();
            }
            return attribute;
        }

        if (attribute_name.equals(Env.ATTRIBUTE_NAME_LocalVariableTypeTable)) {
            LocalVariableTypeTableAttribute attribute = new LocalVariableTypeTableAttribute();
            attribute.attribute_name_index = attribute_name_index;
            attribute.attribute_length = reader.readInt();
            attribute.local_variable_type_table_length = reader.readShort();
            attribute.local_variable_type_table = new LocalVariableTypeInfo[attribute.local_variable_type_table_length];
            for(int i = 0; i < attribute.local_variable_type_table_length; i++){
                attribute.local_variable_type_table[i] = new LocalVariableTypeInfo();
                attribute.local_variable_type_table[i].start_pc = reader.readShort();
                attribute.local_variable_type_table[i].length = reader.readShort();
                attribute.local_variable_type_table[i].name_index = reader.readShort();
                attribute.local_variable_type_table[i].signature_index = reader.readShort();
                attribute.local_variable_type_table[i].index = reader.readShort();
            }
            return attribute;
        }

        if (attribute_name.equals(Env.ATTRIBUTE_NAME_Deprecated)) {
            DeprecatedAttribute attribute = new DeprecatedAttribute();
            attribute.attribute_name_index = attribute_name_index;
            attribute.attribute_length = reader.readInt();
            return attribute;
        }

        if (attribute_name.equals(Env.ATTRIBUTE_NAME_RuntimeVisibleAnnotations)) {
            RuntimeVisibleAnnotationsAttribute attribute = new RuntimeVisibleAnnotationsAttribute();
            throw new IOException();
//            return attribute;
        }

        if (attribute_name.equals(Env.ATTRIBUTE_NAME_RuntimeInvisibleAnnotations)) {
            RuntimeInvisibleAnnotationsAttribute attribute = new RuntimeInvisibleAnnotationsAttribute();
            throw new IOException();
//            return attribute;
        }

        if (attribute_name.equals(Env.ATTRIBUTE_NAME_RuntimeVisibleParameterAnnotations)) {
            RuntimeVisibleParameterAnnotationAttribute attribute = new RuntimeVisibleParameterAnnotationAttribute();
            throw new IOException();
//            return attribute;
        }

        if (attribute_name.equals(Env.ATTRIBUTE_NAME_RuntimeInvisibleParameterAnnotations)) {
            RuntimeInvisibleParameterAnnotationAttribute attribute = new RuntimeInvisibleParameterAnnotationAttribute();
            throw new IOException();
//            return attribute;
        }

        if (attribute_name.equals(Env.ATTRIBUTE_NAME_RuntimeVisibleTypeAnnotations)) {
            RuntimeVisibleTypeAnnotationsAttribute attribute = new RuntimeVisibleTypeAnnotationsAttribute();
            throw new IOException();
//            return attribute;
        }

        if (attribute_name.equals(Env.ATTRIBUTE_NAME_RuntimeInvisibleTypeAnnotations)) {
            RuntimeInvisibleTypeAnnotationsAttribute attribute = new RuntimeInvisibleTypeAnnotationsAttribute();
            throw new IOException();
//            return attribute;
        }

        if (attribute_name.equals(Env.ATTRIBUTE_NAME_AnnotationDefault)) {
            AnnotationDefaultAttribute attribute = new AnnotationDefaultAttribute();
            throw new IOException();
//            return attribute;
        }

        if (attribute_name.equals(Env.ATTRIBUTE_NAME_BootstrapMethods)) {
            BootstrapMethodsAttribute attribute = new BootstrapMethodsAttribute();
            attribute.attribute_name_index = attribute_name_index;
            attribute.attribute_length = reader.readInt();
            attribute.num_bootstrap_methods = reader.readShort();
            attribute.bootstrap_methods = new BootstrapMethodInfo[attribute.num_bootstrap_methods];
            for(int i = 0; i < attribute.num_bootstrap_methods; i++){
                attribute.bootstrap_methods[i] = new BootstrapMethodInfo();
                attribute.bootstrap_methods[i].bootstrap_method_ref = reader.readShort();
                attribute.bootstrap_methods[i].num_bootstrap_arguments = reader.readShort();
                attribute.bootstrap_methods[i].bootstrap_arguments = new short[attribute.bootstrap_methods[i].num_bootstrap_arguments];
                for(int j = 0; j < attribute.bootstrap_methods[i].num_bootstrap_arguments; j++)
                    attribute.bootstrap_methods[i].bootstrap_arguments[j] = reader.readShort();
            }
            return attribute;
        }

        if (attribute_name.equals(Env.ATTRIBUTE_NAME_MethodParameters)) {
            MethodParametersAttribute attribute = new MethodParametersAttribute();
            attribute.attribute_name_index = attribute_name_index;
            attribute.attribute_length = reader.readInt();
            attribute.parameters_count = reader.readByte();
            attribute.parameters = new ParameterInfo[attribute.parameters_count];
            for(int i = 0; i < attribute.parameters_count; i++){
                attribute.parameters[i] = new ParameterInfo();
                attribute.parameters[i].name_index = reader.readShort();
                attribute.parameters[i].access_flags = reader.readShort();
            }
            return attribute;
        }

        throw new IOException();
    }


}
