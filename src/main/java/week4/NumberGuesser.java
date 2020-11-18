package week4;

import java.util.Random;
import java.util.Scanner;

public class NumberGuesser {

    public static void main(String[] args) {

        int number=new Random().nextInt(100)+1;
        NumberGuesser numberGuesser=new NumberGuesser();
        numberGuesser.program(number);


    }

    public void program(int number){
        boolean correct = false;
        Scanner scanner=new Scanner(System.in);
        while (!correct){
            System.out.println("Tipp:");
            int guessNumber = Integer.parseInt(scanner.nextLine());
            if (number>guessNumber){
                System.out.println("nagyobb a keresett szám");
            } else if (number<guessNumber){
                System.out.println("kisebb a keresett szám");
            } else {
                System.out.println("Talált");
                correct=true;
            }
        }
    }

}
