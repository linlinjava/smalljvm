package smalljvm.rtda;

import smalljvm.classfile.AttributeInfo;
import smalljvm.classfile.ConstantInfo;
import smalljvm.classfile.Env;
import smalljvm.classfile.constant.*;

public class KClass {
    String name;
    short accessFlags;

    String superName;
    KClass superClass;

    String[] interfaceNames;
    KClass[] interfaces;

    ConstantInfo[] cp;
    AttributeInfo[] attributes;

    KField[] fields;
    KMethod[] methods;

    int staticSlotCount;
    LocalVariableTable staticSlots;
    int instanceSlotCount;

    ClassLoader loader;

    boolean clinited;

    public String getName() {
        return name;
    }

    public String getSimpleName() {
        int index = name.lastIndexOf("/");
        if(index != -1){
            return name.substring(index+1, name.length());
        }
        return name;
    }

    public String getPackageName() {
        int index = name.lastIndexOf("/");
        if(index != -1){
            return name.substring(0, index);
        }
        return "";
    }

    public boolean isValidAcc(){
        return false;
    }

    public boolean isPublic() {
        return (accessFlags & Env.ACC_PUBLIC) != 0;
    }

    public boolean isFinal() {
        return (accessFlags & Env.ACC_FINAL) != 0;
    }

    public boolean isSuper() {
        return (accessFlags & Env.ACC_SUPER) != 0;
    }

    public boolean isInterface() {
        return (accessFlags & Env.ACC_INTERFACE) != 0;
    }

    public boolean isAbstract() {
        return (accessFlags & Env.ACC_ABSTRACT) != 0;
    }

    public boolean isSynthetic() {
        return (accessFlags & Env.ACC_SYNTHETIC) != 0;
    }

    public boolean isAnnotation() {
        return (accessFlags & Env.ACC_ANNOTATION) != 0;
    }

    public boolean isEnum() {
        return (accessFlags & Env.ACC_ENUM) != 0;
    }

    public String getAcc() {
        String acc = "";
        if(isPublic()) acc += "public ";
        if(isFinal()) acc += "final ";
        if(isAbstract()) acc += "abstract ";
        if(isInterface()) acc += "interface ";
        if(isSuper()) acc += "super ";
        if(isSynthetic()) acc += "synthetic ";
        if(isAnnotation()) acc += "annotation ";
        if(isEnum()) acc += "enum";
        return acc;
    }

    public boolean isAccessibleTo(KClass otherClazz) {
        return isPublic() || (this.getPackageName() == otherClazz.getPackageName());
    }

    public String getSuperName() { return superName; }
    public KClass getSuperClass() {
        return superClass;
    }

    public String[] getInterfaceNames() { return interfaceNames; }
    public KClass[] getInterfaces() {
        return interfaces;
    }

    public boolean isImplementFrom(KClass iface) {
        String interfaceName = iface.getName();
        for (KClass clazz = this; clazz != null; clazz = clazz.getSuperClass()) {
            for (KClass interfaceClass : clazz.interfaces) {

                if (interfaceClass.getName().equals(interfaceName))
                    return true;

                if (interfaceClass.isSubInterfaceOf(iface))
                    return true;
            }
        }
        return false;
    }


    public boolean isAssignableFrom(KClass clazz){
        if (name.equals(clazz.getName())){
            return true;
        }

        if(clazz.isInterface()){
            return isImplementFrom(clazz);
        }
        else{
            return isSubClassOf(clazz);
        }
    }

    // current class should not be an interface
    public boolean isSubClassOf(KClass clazz) {

        for (KClass superclazz = getSuperClass(); superclazz != null; superclazz = superclazz.getSuperClass()) {
            if (superclazz.getName().equals(clazz.getName()))
                return true;
        }

        return false;
    }

    // current class shall be an interface
    public boolean isSubInterfaceOf(KClass interfaceClazz){
        for(KClass iface : interfaces){
            if(iface.getName().equals(interfaceClazz.getName()))
                return true;

            if(iface.isSubInterfaceOf(interfaceClazz))
                return true;
        }

        return false;
    }

    public KField findField(String name, String descriptor) {
        for (KField field : fields){
            if ((name == null || field.getName().equals(name)) && (descriptor == null || field.getDescriptor().equals(descriptor))){
                return field;
            }
        }

        for(KClass interfaceClass : interfaces){
            KField field = interfaceClass.findField(name, descriptor);
            if(field != null)
                return field;
        }

        if(superClass != null){
            KField field = superClass.findField(name, descriptor);
            if(field != null){
                return field;
            }
        }
        return null;
    }


    public KMethod findMethod(String name, String descriptor)    {
        if(isInterface()){
            // see jvm 5.4.3.4

            // 1. find in current interface (actually the class)
            KMethod method = findMethodInClass(name, descriptor);

            // 2. find Object
            if(method == null){
                KClass object_clazz = loader.loadClass("java/lang/Object");
                method = object_clazz.findMethodInClass(name, descriptor);
                if((method != null) && method.isPublic() && !method.isStatic()){
                    return method;
                }
                else{
                    method = null;
                }
            }

            // 3. find in super interfaces
            if(method == null) {
                method = findMethodInSuperInterface(name, descriptor);
            }
            return method;
        }
        else {
            // see jvm 5.4.3.3

            // 1 find in current class
            KMethod method = findMethodInClass(name, descriptor);

            // 2 find in super classes
            if(method == null) {
                method = findMethodInSuperClass(name, descriptor);
            }

            // 3 find in super interfaces
            if (method == null) {
                method = findMethodInSuperInterface(name, descriptor);
            }
            return method;
        }
    }

    public KMethod findMethodInClass(String name, String descriptor) {
        for (KMethod method : methods) {
            if ((name == null || method.getName().equals(name)) &&
                    (descriptor == null || method.getDescriptor().equals(descriptor))) {
                return method;
            }
        }

        return null;
    }

    public KMethod findMethodInSuperClass(String name, String descriptor){
        if(superClass == null)
            return null;

        for (KMethod method : superClass.methods) {
            if ((name == null || method.getName().equals(name)) &&
                    (descriptor == null || method.getDescriptor().equals(descriptor))) {
                return method;
            }
        }

        KMethod method = superClass.findMethodInSuperClass(name, descriptor);
        return method;
    }

    public KMethod findMethodInSuperInterface(String name, String descriptor) {

        for(KClass interfaceClass : interfaces) {
            for (KMethod method : interfaceClass.methods) {
                if ((name == null || method.getName().equals(name)) &&
                        (descriptor == null || method.getDescriptor().equals(descriptor))) {
                    return method;
                }
            }
        }

        for(KClass interfaceClass : interfaces) {
            KMethod method = interfaceClass.findMethodInSuperInterface(name, descriptor);
            if(method != null)
                return method;
        }

        return null;
    }

    private String getUtf(short index){
        ConstantInfo constant = cp[index];
        if (!ConstantInfo.isUtf8(constant)) {
            throw new IllegalStateException("");
        }

        Utf8Constant utf8Constant = (Utf8Constant)constant;
        return utf8Constant.string();
    }

    public ConstantInfo[] getConstantPool(){
        return cp;
    }

    public KObject resolveString(short index){
        return null;
    }

    public KClass resolveClassRef(short index){
        ConstantInfo constantInfo = cp[index];
        if(!ConstantInfo.isClass(constantInfo)){
            throw new IllegalStateException("");
        }

        ClassConstant classConstant = (ClassConstant)constantInfo;
        String className = getUtf(classConstant.name_index);

        KClass clazz = loader.loadClass(className);

        if(clazz == null){
            throw new IllegalStateException("");
        }

        if(!clazz.isAccessibleTo(this)) {
            throw new IllegalStateException("");
        }

        return clazz;
    }

    public KField resolveFieldRef(short index){
        ConstantInfo constantInfo = cp[index];
        if(!ConstantInfo.isFieldRef(constantInfo)){
            throw new IllegalStateException("");
        }
        FieldrefConstant fieldrefConstant = (FieldrefConstant)constantInfo;

        ConstantInfo constantInfo2 = cp[fieldrefConstant.class_index];
        if(!ConstantInfo.isClass(constantInfo2)){
            throw new IllegalStateException("");
        }
        ClassConstant classConstant = (ClassConstant)constantInfo2;
        String className = getUtf(classConstant.name_index);

        KClass clazz = loader.loadClass(className);
        if(clazz == null){
            throw new IllegalStateException("");
        }
        if(!clazz.isAccessibleTo(this))
            throw new IllegalStateException("");

        ConstantInfo constantInfo3 = cp[fieldrefConstant.name_and_type_index];
        if(!ConstantInfo.isNameAndType(constantInfo3)){
            throw new IllegalStateException("");
        }
        NameAndTypeConstant nameAndTypeConstant = (NameAndTypeConstant)constantInfo3;
        String fieldName = getUtf(nameAndTypeConstant.name_index);
        String fieldDescriptor = getUtf(nameAndTypeConstant.descriptor_index);

        KField field = clazz.findField(fieldName, fieldDescriptor);
        if(field == null){
            throw new IllegalStateException("");
        }
        if(!field.isAccessibleTo(this)){
            throw new IllegalStateException("");
        }

        return field;
    }

    public KMethod resolveMethodRef(short index){
        ConstantInfo constantInfo = cp[index];
        if(!ConstantInfo.isMethodref(constantInfo)){
            throw new IllegalStateException("");
        }
        MethodrefConstant methodrefConstant = (MethodrefConstant)constantInfo;

        constantInfo = cp[methodrefConstant.class_index];
        if(!ConstantInfo.isClass(constantInfo)){
            throw new IllegalStateException("");
        }
        ClassConstant classConstant = (ClassConstant)constantInfo;
        String className = getUtf(classConstant.name_index);

        KClass clazz = loader.loadClass(className);
        if(clazz == null){
            throw new IllegalStateException("");
        }
        if(clazz.isInterface()){
            throw new IllegalStateException("IncompatibleClassChangeError");
        }
        if(!clazz.isAccessibleTo(this))
            throw new IllegalStateException("");

        constantInfo = cp[methodrefConstant.name_and_type_index];
        if(!ConstantInfo.isNameAndType(constantInfo)){
            throw new IllegalStateException("");
        }
        NameAndTypeConstant nameAndTypeConstant = (NameAndTypeConstant)constantInfo;
        String fieldName = getUtf(nameAndTypeConstant.name_index);
        String fieldDescriptor = getUtf(nameAndTypeConstant.descriptor_index);

        KMethod method = clazz.findMethod(fieldName, fieldDescriptor);
        if(method == null){
            throw new IllegalStateException("");
        }
        if(!method.isAccessibleTo(this)){
            throw new IllegalStateException("");
        }

        return method;
    }

    public KMethod resolveInterfaceMethodRef(short index){
        ConstantInfo constantInfo = cp[index];
        if(!ConstantInfo.isInterfaceMethodref(constantInfo)){
            throw new IllegalStateException("");
        }
        InterfaceMethodrefConstant interfaceMethodrefConstant = (InterfaceMethodrefConstant)constantInfo;

        constantInfo = cp[interfaceMethodrefConstant.class_index];
        if(!ConstantInfo.isClass(constantInfo)){
            throw new IllegalStateException("");
        }
        ClassConstant classConstant = (ClassConstant)constantInfo;
        String className = getUtf(classConstant.name_index);

        KClass clazz = loader.loadClass(className);
        if(clazz == null){
            throw new IllegalStateException("");
        }
        if(!clazz.isInterface()){
            throw new IllegalStateException("IncompatibleClassChangeError");
        }
        if(!clazz.isAccessibleTo(this)) {
            throw new IllegalStateException("");
        }

        constantInfo = cp[interfaceMethodrefConstant.name_and_type_index];
        if(!ConstantInfo.isNameAndType(constantInfo)){
            throw new IllegalStateException("");
        }
        NameAndTypeConstant nameAndTypeConstant = (NameAndTypeConstant)constantInfo;
        String fieldName = getUtf(nameAndTypeConstant.name_index);
        String fieldDescriptor = getUtf(nameAndTypeConstant.descriptor_index);

        KMethod method = clazz.findMethod(fieldName, fieldDescriptor);
        if(method == null){
            throw new IllegalStateException("");
        }
        if(!method.isAccessibleTo(this)){
            throw new IllegalStateException("");
        }

        return method;
    }

    public LocalVariableTable getStaticSlots() {
        return staticSlots;
    }

    public boolean isClinited(){
        return clinited;
    }

    public void markClinited(){
        clinited = true;
    }

    public KMethod getClinitMethod(){
        for (KMethod method : methods) {
            if (method.getName().equals(KMethod.clinitMethodName) && method.getDescriptor().equals(KMethod.clinitMethodDesc)){
                if(method.isStatic()) {
                    return method;
                }
            }
        }
        return null;
    }

    public KMethod getBootstrapMethod(){
        for (KMethod method : methods) {
            if (method.getName().equals(KMethod.mainMethodName) && method.getDescriptor().equals(KMethod.mainMethodDesc)){
                if(method.isPublic() && method.isStatic()) {
                    return method;
                }
            }
        }
        return null;
    }

    public KMethod getInitMethod(){
        KMethod method = findMethod(KMethod.initMethodName, null);
        return method;
    }

    @Override
    public String toString(){
        String str = "";
        str += "name = " + getName() + "\n";
        str += "simple name = " + getSimpleName() + "\n";
        str += "package name = " + getPackageName() + "\n";
        str += "acc = " + getAcc() + "\n";
        if(superClass != null)
            str += "super class = " + superClass.getName() + "\n";
        for(KClass iface : interfaces)
            str += "interface class = " + iface.getName() + "\n";
        for(KField field: fields)
            str += "field = " + field.getName() + " " + field.getDescriptor() + " " + field.getAcc() + "\n";
        for(KMethod method : methods)
            str += "method = " + method.getName() + " " + method.getDescriptor() + " " + method.getAcc() + "\n";
        return str;
    }
}
