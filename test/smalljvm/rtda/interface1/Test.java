package smalljvm.rtda.interface1;

public class Test {
    public static void main(String[] args) {
        smalljvm.rtda.ClassLoader classLoader = new smalljvm.rtda.ClassLoader(new smalljvm.rtda.MethodArea());
        String className = SubInterface.class.getName();
        className = className.replace('.', '/');
        smalljvm.rtda.KClass clazz = classLoader.loadClass(className);
        System.out.println(clazz);
    }
}
