package numbers;

import java.util.Scanner;

public class MathOperations {
    public static void main(String[] args) {

        System.out.println("Mi az eredmény: 1+(2*3)/4");
        double number=1+(2*3)/4d;
        double yourNumber=new Scanner(System.in).nextDouble();
        if (Math.abs(number-yourNumber)<0.0001){
            System.out.println("helyes");
        } else {
            System.out.println("nem nyert");
        }
    }
}
