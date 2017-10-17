package smalljvm.rtda;

import smalljvm.classfile.ClassFile;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by junling on 2017/3/19.
 */
public class MethodArea {
    Map<String, KClass> classes = new HashMap<String, KClass>();

    public void clear()
    {
        classes.clear();
    }


    public void addClass(KClass clazz)
    {
        classes.put(clazz.getName(), clazz);
    }


    public void removeClass(KClass clazz)
    {
        removeClass(clazz.getName());
    }


    public void removeClass(String className)
    {
        classes.remove(className);
    }


    public KClass getClass(String className)
    {
        return classes.get(className);
    }


    public Iterator classNames()
    {
        return classes.keySet().iterator();
    }


    public int size()
    {
        return classes.size();
    }
}
