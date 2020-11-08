package controlselection.greetings;

public class Greetings {
    public String greeting(int hour, int minute) {
        int n = hour * 60 + minute;
        if (n > 5 * 60 && n <= 9 * 60) {
            return "Jó reggelt!";
        } else if (n > 9 * 60 && n <= 18 * 60 + 30) {
            return "Jó napot!";
        } else if (n > 18 * 60 + 30 && n <= 20 * 60) {
            return "Jó estét!";
        } else {
            return "Jó éjt!";
        }

    }

}
