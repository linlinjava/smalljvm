package smalljvm.interpreter;

import smalljvm.classfile.Instruction;
import smalljvm.rtda.Heap;
import smalljvm.rtda.MethodArea;
import smalljvm.rtda.Thread;

/**
 * Created by junling on 2017/3/31.
 */
public abstract class Interpreter {

    public abstract void execute(Instruction instruction, Thread thread, Heap heap, MethodArea area);

}
