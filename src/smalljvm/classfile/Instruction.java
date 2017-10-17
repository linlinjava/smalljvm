package smalljvm.classfile;

/**
 * Created by junling on 2017/3/19.
 */
public interface Instruction {

    byte opcode();

    String strcode ();

    int length();
}
