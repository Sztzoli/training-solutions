package introcontrol;

import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number=0;
        for (int i = 0; i < 5; i++) {
            System.out.println("adj meg egy számot");
            number+=scanner.nextInt();
        }
        System.out.println(number);

    }
}
