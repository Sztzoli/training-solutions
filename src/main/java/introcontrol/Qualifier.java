package introcontrol;

import java.util.Scanner;

public class Qualifier {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give me a number:");
        int number = scanner.nextInt();

        if (number>100) {
            System.out.println("nagyobb");
        } else if (number==100) {
            System.out.println("egyenlő");
        } else {
            System.out.println("kisebb");
        }
    }
}
