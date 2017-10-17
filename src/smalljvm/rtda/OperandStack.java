package smalljvm.rtda;

/**
 * Created by junling on 2017/3/19.
 */
public class OperandStack {
    int[] m_slots = new int[0];
    int m_size = 0;


    public OperandStack (int stackSize) {
        m_slots = new int[stackSize];
        m_size = 0;
    }

    public int popInt () {
        m_size--;
        return m_slots[m_size];
    }

    public void pushInt (int value) {
        m_slots[m_size] = value;
        m_size++;
    }

    public long popLong () {
        m_size -= 2;
        int low = m_slots[m_size];
        int high = m_slots[m_size+1];
        return (long)high << 32 | (low & 0xFFFFFFFFL);
    }

    public void pushLong (long value) {
        m_slots[m_size] = (int)value;
        m_slots[m_size+1] = (int)(value >> 32);
        m_size += 2;
    }

    public float popFloat () {
        m_size--;
        return Float.intBitsToFloat(m_slots[m_size]);
    }

    public void pushFloat (float value) {
        m_slots[m_size] = Float.floatToIntBits(value);
        m_size++;
    }

    public double popDouble () {
        long lvalue = popLong();
        return Double.longBitsToDouble(lvalue);
    }

    public void pushDouble (double value) {
        long lvalue = Double.doubleToLongBits(value);
        pushLong(lvalue);
    }

    public int popRef () {
        m_size--;
        return m_slots[m_size];
    }

    public void pushRef (int value) {
        m_slots[m_size] = value;
        m_size ++;
    }


    public void pushSlot(int slotValue){
        m_slots[m_size] = slotValue;
        m_size ++;
    }

    public int popSlot() {
        m_size--;
        return m_slots[m_size];
    }

    public int topSlot(){
        return m_slots[m_size-1];
    }

    public int topSlotAtN(int n){
        return m_slots[m_size - 1 - n];
    }


}
