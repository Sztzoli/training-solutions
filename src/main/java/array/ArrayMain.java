package array;

public class ArrayMain {
    public static void main(String[] args) {
        String[] week = {"hetfő", "kedd", "szerda", "csütörtök", "péntek", "szombat", "vasárnap"};
        System.out.println(week[1]);
        System.out.println(week.length);

        int[] powersOfTwo = new int[5];
        int temp = 1;
        for (int i = 0; i < powersOfTwo.length; i++) {
            powersOfTwo[i] = temp;
            temp *= 2;
        }
        for (int number: powersOfTwo
             ) {
            System.out.println(number);
        }

        boolean[] array = new boolean[6];
        for (int i = 0; i < array.length; i++) {
            if (i%2==0) {
                array[i]=false;
            } else {
                array[i]=true;
            }

        }
        for (boolean valami: array
             ) {
            System.out.println(valami);
        }


    }
}
