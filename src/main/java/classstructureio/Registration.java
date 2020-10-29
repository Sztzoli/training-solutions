package classstructureio;


import java.util.Scanner;

public class Registration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please add your user name:");
        String userName = scanner.nextLine();
        System.out.println("Please add your e-mail address");
        String emailUser = scanner.nextLine();
        System.out.println(userName + " e-mail address:" + emailUser);
    }
}
