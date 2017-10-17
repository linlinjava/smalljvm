package smalljvm.rtda;

/**
 * Created by junling on 2017/3/19.
 */
public class Frame {
    KClass m_clazz;
    KMethod m_method;
    int m_pc;

    LocalVariableTable m_localVariableTable = null;
    OperandStack m_operandStack = null;

    public Frame (KMethod method) {
        m_clazz = method.clazz();
        m_method = method;
        m_localVariableTable = new LocalVariableTable(method.maxLocals());
        m_operandStack = new OperandStack(method.maxStack());
    }

    public LocalVariableTable lvt() {
        return m_localVariableTable;
    }

    public OperandStack os() {
        return m_operandStack;
    }

    public KClass clazz() {
        return m_clazz;
    }

    public KMethod method(){
        return m_method;
    }

    public int getPc(){
        return m_pc;
    }

    public void setPc(int pc) {
        m_pc = pc;
    }
}
