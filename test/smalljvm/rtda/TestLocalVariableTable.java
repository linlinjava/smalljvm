package smalljvm.rtda;

public class TestLocalVariableTable {
    public static void main(String[] args) {
        LocalVariableTable lvr = new LocalVariableTable(100);

        lvr.setInt(0, 100);
        lvr.setInt(1, -100);

        lvr.setLong(2, 2999999999L);
        lvr.setLong(4, -2999999999L);

        lvr.setFloat(6, 3.1415F);

        lvr.setDouble(7, 2.999999999);

        System.out.println(lvr.getInt(0));
        System.out.println(lvr.getInt(1));
        System.out.println(lvr.getLong(2));
        System.out.println(lvr.getLong(4));
        System.out.println(lvr.getFloat(6));
        System.out.println(lvr.getDouble(7));

    }
}
