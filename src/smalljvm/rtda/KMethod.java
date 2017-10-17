package smalljvm.rtda;

import smalljvm.classfile.Env;
import smalljvm.classfile.Instruction;
import smalljvm.classfile.InstructionParser;

public class KMethod {

    public static final String mainMethodName   = "main";
    public static final String mainMethodDesc   = "([Ljava/lang/String;)V";
    public static final String clinitMethodName = "<clinit>";
    public static final String clinitMethodDesc = "()V";
    public static final String initMethodName = "<init>";

    String name;
    short accessFlags;
    String descriptor;

    KClass clazz;

    byte[] codes = new byte[0];
    int maxStack;
    int maxLocals;
    Instruction[] instructions = new Instruction[0];

    public String getName() {
        return name;
    }

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

    public boolean isSynchronized() {
        return (accessFlags & Env.ACC_SYNCHRONIZED) != 0;
    }

    public boolean isBridge() {
        return (accessFlags & Env.ACC_BRIDGE) != 0;
    }

    public boolean isVarargs() {
        return (accessFlags & Env.ACC_VARARGS) != 0;
    }

    public boolean isNative() {
        return (accessFlags & Env.ACC_NATIVE) != 0;
    }

    public boolean isAbstract() {
        return (accessFlags & Env.ACC_ABSTRACT) != 0;
    }

    public boolean isStrict() {
        return (accessFlags & Env.ACC_STRICT) != 0;
    }

    public boolean isSynthetic() {
        return (accessFlags & Env.ACC_SYNTHETIC) != 0;
    }

    public String getAcc() {
        String acc = "";
        if(isPublic()) acc += "public ";
        if(isPrivate()) acc += "private ";
        if(isProtected()) acc += "protected ";
        if(isStatic()) acc += "static ";
        if(isFinal()) acc += "final ";
        if(isAbstract()) acc += "abstract ";
        if(isSynchronized()) acc += "synchronized ";
        if(isBridge()) acc += "bridge ";
        if(isSynthetic()) acc += "synthetic ";
        if(isVarargs()) acc += "varargs ";
        if(isNative()) acc += "native ";
        if(isStrict()) acc += "strict ";

        return acc;
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

    public boolean isInitMethod() {
        return name.equals(initMethodName);
    }

    public boolean isClinitMethod() {
        return name.equals(clinitMethodName) && descriptor.equals(clinitMethodDesc);
    }

    public boolean isBootstrapMethod() {
        return isPublic() & isStatic() && name.equals(mainMethodName) && descriptor.equals(mainMethodDesc);
    }

    public String getDescriptor() {
        return descriptor;
    }

    public int getArgSlotsCount(){
        // see jvms 4.3.3
        char[] data = descriptor.toCharArray();
        int index1 = descriptor.indexOf('(');
        int index2 = descriptor.indexOf(')');
        int slotsCount = 0;
        boolean parseVector = false;
        for(int index = index1+1; index < index2; ){
            char c = data[index];
            if(c == 'B' || c == 'C' || c == 'F' || c == 'I' || c == 'S' || c == 'Z'){
                if (!parseVector) {
                    slotsCount++;
                }
                else{
                    parseVector = false;
                }
                index++;
            }
            else if(c == 'D' || c == 'J'){
                if (!parseVector) {
                    slotsCount += 2;
                }
                else{
                    parseVector = false;
                }
                index++;
            }
            else if(c == 'L'){
                if (!parseVector) {
                    slotsCount++;
                }
                else{
                    parseVector = false;
                }
                for(; index < index2; index++) {
                    if(data[index] == ';') {
                        index++;
                        break;
                    }
                }
            }
            else if(c == '['){
                if (!parseVector) {
                    slotsCount++;
                    parseVector = true;
                }
                index++;
            }
        }

        return slotsCount;
    }

    public int getArgCount(){
        char[] data = descriptor.toCharArray();
        int index1 = descriptor.indexOf('(');
        int index2 = descriptor.indexOf(')');
        int argCount = 0;
        boolean parseVector = false;
        for(int index = index1+1; index < index2; ){
            char c = data[index];
            if(c == 'B' || c == 'C' || c == 'F' || c == 'I' || c == 'S' || c == 'Z'){
                if (!parseVector) {
                    argCount++;
                }
                else{
                    parseVector = false;
                }
                index++;
            }
            else if(c == 'D' || c == 'J'){
                if (!parseVector) {
                    argCount += 1;
                }
                else{
                    parseVector = false;
                }
                index++;
            }
            else if(c == 'L'){
                if (!parseVector) {
                    argCount++;
                }
                else{
                    parseVector = false;
                }
                for(; index < index2; index++) {
                    if(data[index] == ';') {
                        index++;
                        break;
                    }
                }
            }
            else if(c == '['){
                if (!parseVector) {
                    argCount++;
                    parseVector = true;
                }
                index++;
            }
        }

        return argCount;
    }

    public KClass clazz() { return clazz; }

    public int maxLocals() {
        return maxLocals;
    }

    public int maxStack() {
        return maxStack;
    }

    public byte[] codes() {
        return codes;
    }

    public Instruction[] instructions () {
        if(instructions.length == 0){
            instructions = InstructionParser.parse(codes);
        }
        return instructions;
    }


}
