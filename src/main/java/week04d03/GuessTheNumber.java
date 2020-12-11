package week04d03;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {

    public static void main(String[] args) {

        int number=new Random(1).nextInt(100)+1;
        System.out.println(number);
        GuessTheNumber numberGuesser=new GuessTheNumber();
        numberGuesser.program(number);


    }

    public void program(int number){
        boolean correct = false;
        Scanner scanner=new Scanner(System.in);
        int count=0;
        while (count<6 && !correct){
            System.out.println("Tipp:");
            int guessNumber = Integer.parseInt(scanner.nextLine());
            if (number>guessNumber){
                System.out.println("nagyobb a keresett szám");
                count++;
            } else if (number<guessNumber){
                System.out.println("kisebb a keresett szám");
                count++;
            } else {
                System.out.println("Talált");
                correct=true;
            }
        }
        if (count==6){
            System.out.println("vesztes");
        }
    }

}
