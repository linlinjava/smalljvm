package smalljvm.launcher;

import smalljvm.interpreter.JVM;

import java.io.IOException;

public class Launcher {

    public static void main(String[] args){
        JVM JVM = new JVM();
        try {
            JVM.run(args[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
