package introcontrol;

import java.util.Scanner;

public class UserMenu {
    public static void main(String[] args) {
        System.out.println("1.Felhasználok listázása");
        System.out.println("2. Felhasználok felvétel");
        System.out.println("Többi: kilépés");

        Scanner scanner = new Scanner(System.in);
        System.out.println("írj be egy számot");
        int number=scanner.nextInt();

        if (number==1) {
            System.out.println("Felhasználok listázása");
        } else if (number==2){
            System.out.println("Felhasználok felvétele");
        }

    }
}
