package introcontrol;

import java.util.Scanner;

public class BoatRental {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("fő:");
        int number = scanner.nextInt();
        int numberOfBoats = 3;
        int freePlace = 10;
        int boat1 = 5;
        int boat2 = 3;
        int boat3 = 2;



        if (number >= 4) {
            numberOfBoats--;
            number -= 5;
            System.out.println("5 lefoglalva");
            freePlace-=5;
        }
        if (number >= 3) {
            numberOfBoats--;
            number -= 3;
            System.out.println(("3 lefoglalva"));
            freePlace-=3;
        }
        if (number > 0) {
            numberOfBoats--;
            number-=2;
            System.out.println("2 lefoglalva");
            freePlace-=2;
        }
        System.out.println(freePlace+" db szabad hely");
        if(number>freePlace) {
            System.out.println("várakozok száma: "+number);
        }


    }
}
