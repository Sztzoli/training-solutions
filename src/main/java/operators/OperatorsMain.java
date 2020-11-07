package operators;

public class OperatorsMain {
    public static void main(String[] args) {
        Operators operators = new Operators();
        System.out.println(operators.isEven(11));

        System.out.println(16<<1);
        System.out.println(16>>1);
        System.out.println(13<<1);
        System.out.println(13>>1);

        System.out.println(operators.multiplyByPowerOfTwo(13,2));


        int i = -1;
        String s = Integer.toBinaryString(i);
        System.out.println(s);
        int j = Long.valueOf(s,2).intValue();
        System.out.println(j);

        System.out.println(0333);

    }

}
