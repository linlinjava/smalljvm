package smalljvm.rtda;

public class TestKClass {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        KClass clazz = new KClass();
        clazz.name = "java/lang/Object";
        String simpleName = clazz.getSimpleName();
        String packageName = clazz.getPackageName();
        System.out.println(simpleName);
        System.out.println(packageName);
    }
}
