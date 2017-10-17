package smalljvm.rtda;

public class KObject {
    KClass clazz;
    int id;
    LocalVariableTable slots;

    public int id() {
        return id;
    }

    public KClass clazz() {
        return clazz;
    }

    public LocalVariableTable slots() {
        return slots;
    }
}
