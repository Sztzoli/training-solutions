package exam03retake01;

//8365670003
//1 * 8 + 2 * 3 + 3 * 6 + ... + 9 * 0 = 124
//124 maradékos osztás 11-el = 3
//3 (maradék) == 3 (10. számhegy) - az adószám megfelelő
public class CdvCheck {
    public boolean check(String s) {
        validateTaxNumber(s);
        String[] parts = s.split("");
        int result = getResult(parts);
        if (result % 11 == Integer.parseInt(parts[9])) {
            return true;
        }
        return false;
    }

    private int getResult(String[] parts) {
        int result = 0;
        for (int i = 0; i < 9; i++) {
            result += (Integer.parseInt(parts[i]) * (i + 1));
        }
        return result;
    }

    private void validateTaxNumber(String s) {
        if (s.length() != 10) {
            throw new IllegalArgumentException("Not 10 digits");
        }
        if (!s.matches("[0-9]+")) {
            throw new IllegalArgumentException("Not only number");
        }
    }
}
