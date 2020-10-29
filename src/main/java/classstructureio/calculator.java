package classstructureio;


import java.util.Scanner;

public class calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the first number");
        int firstNumber = scanner.nextInt();
        System.out.println("Please enter the second number");
        int secondNumber = scanner.nextInt();

        System.out.println(firstNumber + " + " + secondNumber);
        System.out.println("("+(firstNumber+secondNumber) +")");
    }
}
