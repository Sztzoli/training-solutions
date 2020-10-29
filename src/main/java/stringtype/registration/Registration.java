package stringtype.registration;

import java.util.Scanner;

public class Registration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserValidator userValidator = new UserValidator();

        System.out.println("username:");
        String username = scanner.nextLine();
        System.out.println(userValidator.isCorrect(userValidator.isValidUsername(username)));

        System.out.println("password:");
        String password1 = scanner.nextLine();
        System.out.println("password again:");
        String password2 = scanner.nextLine();
        System.out.println(userValidator.isCorrect(userValidator.isValidPassword(password1,password2)));

        System.out.println("email:");
        String email = scanner.nextLine();
        System.out.println(userValidator.isCorrect(userValidator.isValidEmail(email)));
    }
}
