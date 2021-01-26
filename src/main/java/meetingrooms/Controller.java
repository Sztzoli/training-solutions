package meetingrooms;

import java.util.Scanner;

public class Controller {
    private Office office;

    Scanner scanner = new Scanner(System.in);

    public void readOffice() {
        office = new Office();
        System.out.println("Hány db tárgyalót szeretne rögzíteni:");
        int numberOfMeetingRoom = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numberOfMeetingRoom; i++) {
            System.out.println("Tárgyaló neve:");
            String name = scanner.nextLine();
            System.out.println("Tárgyaló szélessége:");
            int length = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Tárgyaló hossza:");
            int width = scanner.nextInt();
            scanner.nextLine();
            office.AddMeetingRoom(new MeetingRoom(name, length, width));
        }
    }

    public void printMenu() {
        System.out.println("1. Tárgyalók sorrendben");
        System.out.println("2. Tárgyalók visszafele sorrendben");
        System.out.println("3. Minden második tárgyaló");
        System.out.println("4. Területek");
        System.out.println("5. Keresés pontos név alapján");
        System.out.println("6. Keresés névtöredék alapján");
        System.out.println("7. Keresés terület alapján");
    }

    public void runMenu() {
        System.out.println("Válasz egy menüpontot");
        int numberOfMenu = scanner.nextInt();

        switch (numberOfMenu) {
            case 1:
                office.PrintNames();
                break;
            case 2:
                office.PrintNamesReverse();
                break;
            case 3:
                office.PrintEvenNames();
                break;
            case 4:
                office.printAreas();
                break;
            case 5:
                System.out.println("Adj a nevet akire keresel");
                scanner.nextLine();
                office.printMeetingRoomsWithName(scanner.nextLine());
                break;
            case 6:
                System.out.println("Adj egy névtöredéket");
                scanner.nextLine();
                office.printMeetingRoomsContains(scanner.nextLine());
                break;
            case 7:
                System.out.println("Adj egy területet");
                office.printAreasLargerThan(scanner.nextInt());
                break;
            default:
                System.out.println("Rossz a szám");
                break;
        }

    }


    public static void main(String[] args) {
        Controller controller= new Controller();
        controller.readOffice();
        controller.printMenu();
        controller.runMenu();



    }
}
