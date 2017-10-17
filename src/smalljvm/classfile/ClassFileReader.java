package smalljvm.classfile;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ClassFileReader {

    // classpath
    // 1. dir, like ".", "a/", "a", "a/b/c/"
    // 2. zipped file, like "a.jar", "a/b.jar", "a/b/c.zip"
    // 3. wildcard zipped files, like "a/*", "a/b/*"
    // 4. composite path with 1, 2 and 3, like ".;a/", ".;a/;b/*;c.zip"
    public DataInput read(String classpath, String className) {
        if (classpath == null || className == null) {
            return null;
        }

        String[] cps = classpath.split(";");
        DataInput input = null;

        for (String cp : cps) {
            if (cp == null)
                continue;

            // 3
            if (cp.charAt(cp.length() - 1) == '*') {
                cp = cp.substring(0, cp.length() - 1);
                File cpdir = new File(cp);
                for (File cpfile : cpdir.listFiles()) {
                    if (!cpfile.isFile())
                        continue;
                    input = readFile(cpfile, className);
                    if (input != null)
                        return input;
                }
            }

            File fileordir = new File(cp);
            if (fileordir == null || !fileordir.exists()) {
                continue;
            }

            // 2
            if (fileordir.isDirectory()) {
                input = readDir(fileordir, className);
                if (input != null)
                    return input;
            }

            // 1, although file with suffix like ".jar" or ".zip" is suggested, here we take each file as zipped file
            if (fileordir.isFile()) {
                input = readFile(fileordir, className);
                if (input != null)
                    return input;
            }

        }

        return null;
    }

    private DataInput readFile(File file, String className) {
        try {
            ZipFile zf = new ZipFile(file);
            String entryName = className + ".class";
            ZipEntry entry = zf.getEntry(entryName);
            if(entry == null)
                return null;
            DataInput input = new DataInputStream(zf.getInputStream(entry));
            return input;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private DataInput readDir(File dir, String className) {
        File classfile = new File(dir, className + ".class");
        if (classfile.exists()) {
            try {
                DataInput input = new DataInputStream(new FileInputStream(classfile));
                return input;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

}