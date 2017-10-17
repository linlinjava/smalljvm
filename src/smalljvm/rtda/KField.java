package smalljvm.rtda;

import smalljvm.classfile.Env;

public class KField {
    String name;
    short accessFlags;
    String descriptor;

    KClass clazz;
    
    int slotId;

    public String getName() { return name; }

    public boolean isValidAcc(){
        return false;
    }
    
    public boolean isPublic() {
        return (accessFlags & Env.ACC_PUBLIC) != 0;
    }

    public boolean isPrivate() {
        return (accessFlags & Env.ACC_PRIVATE) != 0;
    }

    public boolean isProtected() {
        return (accessFlags & Env.ACC_PROTECTED) != 0;
    }

    public boolean isStatic() {
        return (accessFlags & Env.ACC_STATIC) != 0;
    }

    public boolean isFinal() {
        return (accessFlags & Env.ACC_FINAL) != 0;
    }

    public boolean isVolatile() {
        return (accessFlags & Env.ACC_VOLATILE) != 0;
    }

    public boolean isTransient() {
        return (accessFlags & Env.ACC_TRANSIENT) != 0;
    }

    public boolean isSynthetic() {
        return (accessFlags & Env.ACC_SYNTHETIC) != 0;
    }

    public boolean isEnum() {
        return (accessFlags & Env.ACC_ENUM) != 0;
    }

    public String getAcc(){
        String acc = "";
        if(isPublic()) acc += "public ";
        if(isPrivate()) acc += "private ";
        if(isProtected()) acc += "protected ";
        if(isStatic()) acc += "static ";
        if(isFinal()) acc += "final ";
        if(isVolatile()) acc += "volatile ";
        if(isTransient()) acc += "transient ";
        if(isEnum()) acc += "enum ";
        if(isSynthetic()) acc += "synthetic ";
        return acc;
    }

    public boolean isSingleSlot() {
        return !isDoubleSlots();
    }

    public boolean isDoubleSlots() {
        return descriptor.charAt(0) == 'J' || descriptor.charAt(0) == 'D';
    }

    public String getDescriptor() {
        return descriptor;
    }

    public boolean isAccessibleTo(KClass otherClazz){
        if (isPublic()){
            return true;
        }

        if(isProtected()){
            return (clazz == otherClazz) || (otherClazz.isSubClassOf(clazz)) || (clazz.getPackageName().equals(otherClazz.getPackageName()));
        }

        if(!isPrivate()){
            return (clazz.getPackageName().equals(otherClazz.getPackageName()));
        }

        return clazz == otherClazz;
    }

    public KClass getKClass(){
        return clazz;
    }

    public int getSlotId(){
        return slotId;
    }
}
