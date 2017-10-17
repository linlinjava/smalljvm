package smalljvm.interpreter;

import smalljvm.classfile.*;
import smalljvm.rtda.*;
import smalljvm.rtda.ClassLoader;

import java.io.IOException;

public class JVM {
    smalljvm.rtda.Thread thread = new smalljvm.rtda.Thread();
    smalljvm.rtda.Heap heap = new smalljvm.rtda.Heap();
    smalljvm.rtda.MethodArea area = new smalljvm.rtda.MethodArea();
    smalljvm.rtda.ClassLoader loader = new ClassLoader(area);
    smalljvm.interpreter.Interpreter interpreter = new DefaultInterpreter();

    public smalljvm.rtda.Thread thread(){
        return thread;
    }

    public smalljvm.rtda.Heap heap(){
        return heap;
    }

    public smalljvm.rtda.MethodArea methodarea(){
        return area;
    }

    public smalljvm.rtda.ClassLoader classloader(){
        return loader;
    }

    public smalljvm.interpreter.Interpreter interpreter(){
        return interpreter;
    }

    public void run (String className) throws IOException {
        KClass bootstrapClazz = loader.loadClass(className);
        KMethod bootstrapMethod = bootstrapClazz.getBootstrapMethod();

        if (bootstrapMethod == null) {
            return;
        }

        Frame frame = new Frame(bootstrapMethod);
        thread.pushFrame(frame);
        thread.setPc(0);

        // pass string args

        while(thread.curFrame() != null){
            Frame cur = thread.curFrame();
            KMethod method = cur.method();
            KClass clazz = method.clazz();
            byte[] codes = method.codes();
            int pc = thread.getPc();

            Instruction instruction = InstructionParser.parse(codes, pc);

            thread.nextPc(instruction.length());

            System.out.println(clazz.getName() + " " + method.getName() + " " + instruction.toString());
            interpreter.execute(instruction, thread, heap, area);
        }
    }
}
