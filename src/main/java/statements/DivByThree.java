package statements;

import java.util.Scanner;

public class DivByThree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number");
        int number = scanner.nextInt();
        String message = number % 3 == 0 ? number+" is div by three" : number+" is not div by three";
        System.out.println(message);
    }
}
