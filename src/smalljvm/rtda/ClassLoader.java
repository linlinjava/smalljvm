package smalljvm.rtda;

import smalljvm.classfile.*;
import smalljvm.classfile.attribute.CodeAttribute;

import java.io.DataInput;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by junling on 2017/4/15.
 */
public class ClassLoader {
    ClassFileReader reader = new ClassFileReader();
    ClassFileParser parser = new ClassFileParser();

    MethodArea methodArea = null;

    public ClassLoader(MethodArea area) {
        methodArea = area;
    }

    // clazzName shall be like java/lang/Object
    public KClass loadClass(String clazzName){

        KClass c = findLoadedClass(clazzName);

        if(c != null)
            return c;

        ClassFile classFile = readClass(clazzName);

        if(classFile == null){
            return null;
        }

        c = defineClass(classFile);

        linkClass(c);

        return c;
    }

    private final KClass findLoadedClass(String name) {
        return methodArea.getClass(name);
    }

    private ClassFile readClass(String name) {
        ClassFile classFile = findBoostrapClass(name);

        if (classFile == null){
            classFile = findExtensionClass(name);
        }

        if (classFile == null) {
            classFile = findAppClass(name);
        }

        if (classFile == null) {
            classFile = findClass(name);
        }
        return classFile;
    }

    private final ClassFile findBoostrapClass (String name) {
        String javahome = System.getenv("JAVA_HOME");
        String boostrap_home = javahome + "/lib/";

        ClassFile c = null;

        try {
            ClassFileReader reader = new ClassFileReader();
            DataInput input = reader.read(boostrap_home, name);

            ClassFileParser parser = new ClassFileParser();
            c = parser.parse(input);
            return c;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private final ClassFile findExtensionClass (String name) {
        String javahome = System.getenv("JAVA_HOME");
        String extension_home1 = javahome + "/lib/ext/";
        String extension_home2 = System.getProperty("java.ext.dir");
        String extension_home = extension_home1 + ";" + extension_home2;
        ClassFile c = null;

        try {
            ClassFileReader reader = new ClassFileReader();
            DataInput input = reader.read(extension_home, name);
            ClassFileParser parser = new ClassFileParser();
            c = parser.parse(input);
            return c;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private final ClassFile findAppClass (String name) {
        String classpath1 = System.getenv("CLASSPATH");
        String classpath2 = System.getProperty("java.class.path");
        String classpath = classpath1 + ";" + classpath2;
        ClassFile c = null;

        try {
            ClassFileReader reader = new ClassFileReader();
            DataInput input = reader.read(classpath, name);
            ClassFileParser parser = new ClassFileParser();
            c = parser.parse(input);
            return c;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected ClassFile findClass (String name) {
        return null;
    }

    protected final KClass defineClass(ClassFile classFile) {
        KClass clazz = new KClass();
        clazz.accessFlags = classFile.access_flags;
        clazz.name = classFile.getName();
        clazz.superName = classFile.getSuperName();
        if(!clazz.name.equals("java/lang/Object")){
            clazz.superClass = loadClass(clazz.superName);
        }
        clazz.interfaceNames = new String[classFile.interfaces_count];
        for(short i = 0 ; i < classFile.interfaces_count; i++){
            clazz.interfaceNames[i] = classFile.getInterfaceName(i);
        }
        clazz.interfaces = new KClass[classFile.interfaces_count];
        for(short i = 0 ; i < classFile.interfaces_count; i++){
            clazz.interfaces[i] = loadClass(clazz.interfaceNames[i]);
        }
        clazz.cp = classFile.constant_pool;
        clazz.attributes = classFile.attributes;

        clazz.fields = new KField[classFile.fields_count];
        for(int i = 0; i < classFile.fields_count; i++) {
            clazz.fields[i] = new KField();
            KField field = clazz.fields[i];
            FieldInfo fieldInfo = classFile.fields[i];
            field.name = fieldInfo.getName();
            field.accessFlags = fieldInfo.getAccessFlags();
            field.descriptor = fieldInfo.getDescriptor();
            field.clazz = clazz;
            // field.slotId will be set in prepareClass process.
        }

        clazz.methods = new KMethod[classFile.methods_count];
        for(int i = 0; i < classFile.methods_count; i++){
            clazz.methods[i] = new KMethod();
            KMethod method = clazz.methods[i];
            MethodInfo methodInfo = classFile.methods[i];
            method.name = methodInfo.getName();
            method.accessFlags = methodInfo.getAccessFlags();
            method.descriptor = methodInfo.getDescriptor();
            method.clazz = clazz;

            CodeAttribute codeAttribute = methodInfo.codeAttribute();
            if(codeAttribute != null) {
                method.codes = codeAttribute.code;
                method.maxStack = codeAttribute.max_stack;
                method.maxLocals = codeAttribute.max_locals;
                // method.instructions will be lazy parsed until it is required.
            }

        }

        clazz.loader = this;

        methodArea.addClass(clazz);

        return clazz;
    }


    protected final void linkClass (KClass c) {
        verifyClass(c);
        prepareClass(c);
    }

    protected final void verifyClass (KClass c) {

    }

    protected final void prepareClass (KClass c) {
        calInstanceFieldSlots(c);
        calStaticFieldSlots(c);
        allocStaticField(c);
    }

    private void calInstanceFieldSlots(KClass c) {
        int id = 0;
        KClass kc = c.getSuperClass();
        if(kc != null){
            id = kc.instanceSlotCount;
        }

        for(KField field : c.fields){

            if(field.isStatic())
                continue;

            field.slotId = id++;
            if(field.isDoubleSlots()){
                id++;
            }

        }

        c.instanceSlotCount = id;
    }

    private void calStaticFieldSlots(KClass c) {
        int id = 0;

        for(KField field : c.fields){

            if(!field.isStatic())
                continue;

            field.slotId = id++;
            if(field.isDoubleSlots()){
                id++;
            }

        }

        c.staticSlotCount = id;
    }

    private void allocStaticField(KClass c) {
        c.staticSlots = new LocalVariableTable(c.staticSlotCount);
        for(KField field : c.fields){

        }
    }




}
