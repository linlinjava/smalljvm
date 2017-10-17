package smalljvm.rtda;

import java.util.Stack;

/**
 * Created by junling on 2017/3/19.
 */
public class Thread {
    int m_pc = -1;
    Stack<Frame> m_stack = new Stack<Frame>();

    public void nextPc(){
        m_pc++;
    }

    public void nextPc(int offset){
        m_pc += offset;
    }

    public void setPc (int pc) {
      m_pc = pc;
    }

    public int getPc () {
        return m_pc;
    }

    public void pushFrame (Frame frame) {
        Frame cur = curFrame();;
        if(cur != null){
            cur.setPc(m_pc);
        }
        m_stack.push(frame);
        m_pc = 0;
    }

    public void pushFrame (Frame frame, int pc) {
        Frame cur = curFrame();
        if(cur != null){
            cur.setPc(pc);
        }
        m_stack.push(frame);
        m_pc = 0;
    }

    public Frame popFrame () {
        Frame top = m_stack.pop();
        Frame cur = curFrame();
        if(cur == null){
            m_pc = 0;
        }
        else {
            m_pc = cur.getPc();
        }
        return top;
    }

    public Frame curFrame () {
        if(m_stack.empty()){
            return null;
        }
        return m_stack.peek();
    }
}
