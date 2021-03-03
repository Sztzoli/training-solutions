package covid;

import java.util.Scanner;

public class CovidMain {

    private Scanner scanner = new Scanner(System.in);
    private CovidService service;

    public CovidMain(CovidService service) {
        this.service = service;
    }

    public void loadMenu() {
        initMenu();
        menu();
    }

    public void initMenu() {
        String menu =
                """
                        1. Regisztráció
                        2. Tömeges regisztráció
                        3. Generálás
                        4. Oltás
                        5. Oltás meghiúsulás
                        6. Riport2""";
        System.out.println(menu);

    }

    public void menu() {
        System.out.println("Choose from menu");
        int menuPoint = Integer.parseInt(scanner.nextLine());

        switch (menuPoint) {
            case 1 -> service.registration();
            case 2 -> service.registrationFromList();
            case 3 -> service.generation();
            case 4 -> service.vaccination();
            case 5 -> service.vaccinationFail();
            case 6 -> service.riport();
        }
        loadMenu();
    }

    public static void main(String[] args) {
        CovidMain covidMain = new CovidMain(new CovidService());
        covidMain.initMenu();
        covidMain.menu();
    }
}
