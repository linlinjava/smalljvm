package smalljvm.rtda;

/**
 * Created by junling on 2017/3/19.
 */
public class Heap {
    int id = 1;
    java.util.Map<Integer, smalljvm.rtda.KObject> kobjects = new java.util.HashMap<Integer, smalljvm.rtda.KObject>();

    public KObject newObject(KClass clazz){
        KObject kobject = new KObject();
        kobject.clazz = clazz;
        kobject.id = id++;
        kobject.slots = new LocalVariableTable(clazz.instanceSlotCount);
        kobjects.put(kobject.id, kobject);
        return kobject;
    }

    public KObject findObject(int id){
        return kobjects.get(id);
    }


}
