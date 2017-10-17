package smalljvm.classfile;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class TestClassFileReader {
    static void testzip() {
        String javahome = System.getenv("JAVA_HOME");
        System.out.println("javahome=" + javahome);

        String jarfile = javahome + "/jre/lib/jfxswt.jar";
        System.out.println("jarfile=" + jarfile);

        try {
            ZipFile zf = new ZipFile(jarfile);
            ZipEntry entry = zf.getEntry("javafx/embed/swt/CustomTransfer.class");
            System.out.println("entry=" + entry.getName() + " " + entry.getSize());
            DataInputStream input = new DataInputStream(zf.getInputStream(entry));
            System.out.println(input.available());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static void testdir(){
        try {
            File classfile = new File("out/test/smalljvm/","smalljvm/rtda/Hello.class");
            System.out.println("file=" + classfile.getAbsolutePath());
            DataInputStream input = new DataInputStream(new FileInputStream(classfile));
            System.out.println(input.available());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void testPath(){
        File dir = new File(".");
        System.out.println(dir.getAbsolutePath());
        System.out.println(dir.exists());
        System.out.println(dir.isDirectory());

        File file = new File("out/test/smalljvm/smalljvm/classfile/Hello.class");
        System.out.println(file.getAbsolutePath());
        System.out.println(file.exists());
        System.out.println(file.isFile());

        File file2 = new File(new File("."), "out/test/smalljvm/smalljvm/classfile/Hello.class");
        System.out.println(file2.getAbsolutePath());
        System.out.println(file2.exists());
        System.out.println(file2.isFile());

        File file3 = new File(new File("out/test/smalljvm/"), "smalljvm/classfile/Hello.class");
        System.out.println(file3.getAbsolutePath());
        System.out.println(file3.exists());
        System.out.println(file3.isFile());
    }

    static void testReader(){
        ClassFileReader reader = new ClassFileReader();

        DataInput input = reader.read("out/test/smalljvm/", "smalljvm/classfile/Hello");
        System.out.println(input != null);

        input = reader.read(System.getenv("JAVA_HOME")+"/jre/lib/rt.jar", "java/lang/Object");
        System.out.println(input != null);
    }

    public static void main(String[] args) {
        testPath();
        testdir();
        testzip();
        testReader();
    }
}
