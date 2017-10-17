package smalljvm.rtda;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

public class TestClassLoader {
    static void testPath(){
        String javahome = System.getenv("JAVA_HOME");
        System.out.println("javahome=" + javahome);

        String boostrap_home = System.getenv("JAVA_HOME") + "/lib/";
        System.out.println("boostrap_home=" + boostrap_home);

        String extension_home1 = javahome + "/lib/ext/";
        System.out.println("extension_home1=" + extension_home1);

        String extension_home2 = System.getProperty("java.ext.dir");
        System.out.println("extension_home2=" + extension_home2);

        String classpath1 = System.getenv("CLASSPATH");
        System.out.println("classpath1" + classpath1);

        String classpath2 = System.getProperty("java.class.path");
        System.out.println("classpath2" + classpath2);
    }

    static void test2(){
        ClassLoader classLoader = new ClassLoader(new MethodArea());
        KClass clazz = classLoader.loadClass("smalljvm/rtda/Hello");
        System.out.println(clazz);
    }

    static void test3(){
        ClassLoader classLoader = new ClassLoader(new MethodArea());
        KClass clazz = classLoader.loadClass("java/lang/Object");
        System.out.println(clazz);
    }

    public static void main(String[] args) {
        test2();
        test3();
    }
}
