package primitivetypes;

public class PrimitiveTypesMain {
    public static void main(String[] args) {
        PrimitiveTypes primitiveTypes=new PrimitiveTypes();
        System.out.println(primitiveTypes.toBinaryString(9));
        System.out.println(Integer.toBinaryString(9));
        System.out.println(primitiveTypes.toBinaryString(9).equals(Integer.toBinaryString(9)));

        System.out.println(new Integer(1)+new Integer(2));

    }
}
