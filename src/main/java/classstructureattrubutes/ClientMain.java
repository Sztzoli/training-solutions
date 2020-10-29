package classstructureattrubutes;

import java.util.Scanner;

public class ClientMain {
    public static void main(String[] args) {
        Client client = new Client();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please add client name");
        client.name=scanner.nextLine();
        System.out.println("Please add client address");
        client.address = scanner.nextLine();
        System.out.println("Please add client birthyear");
        client.year=scanner.nextInt();

        System.out.println(client.name + "year of birth: " + client.year + " address: " + client.address);




    }
}
