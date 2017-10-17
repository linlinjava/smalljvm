package smalljvm.rtda;

/**
 * Created by junling on 2017/3/19.
 */
public class LocalVariableTable {
    int[] m_slots = new int[0];

    public LocalVariableTable(int size) {
        m_slots = new int[size];
    }

    public int getInt (int index) {
        return m_slots[index];
    }

    public void setInt (int index, int value) {
        m_slots[index] = value;
    }

    public long getLong (int index) {
        int low = m_slots[index];
        int high = m_slots[index+1];
        return (long)high << 32 | (low & 0xFFFFFFFFL);
    }

    public void setLong (int index, long value) {
        m_slots[index] = (int)value;
        m_slots[index+1] = (int)(value >> 32);
    }

    public float getFloat (int index) {
        return Float.intBitsToFloat(m_slots[index]);
    }

    public void setFloat (int index, float value) {
        m_slots[index] = Float.floatToIntBits(value);
    }

    public double getDouble (int index) {
        int low = m_slots[index];
        int high = m_slots[index+1];
        long lvalue = (long)high << 32 | (low & 0xFFFFFFFFL);
        return Double.longBitsToDouble(lvalue);
    }

    public void setDouble (int index, double value) {
        long lvalue = Double.doubleToLongBits(value);
        m_slots[index] = (int)lvalue;
        m_slots[index+1] = (int)(lvalue >> 32);
    }

    public int getRef (int index) {
        return m_slots[index];
    }

    public void setRef (int index, int value) {
        m_slots[index] = value;
    }

    public void setSlot(int index, int value) {
        m_slots[index] = value;
    }
}
