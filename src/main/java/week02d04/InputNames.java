package week02d04;

import java.util.Scanner;

public class InputNames {
    public static void main(String[] args) {
        String[] array= new String[5];
        Scanner scanner=new Scanner(System.in);
        for (int i = 0; i < array.length; i++) {
            System.out.println("Adj meg egy nevet:");
            array[i]= scanner.nextLine();
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println((i+1)+". elem: "+ array[i]);

        }
    }
}
