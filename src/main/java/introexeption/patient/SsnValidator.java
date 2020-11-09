package introexeption.patient;

public class SsnValidator {
    public boolean isValidSsn(String ssn) {
        if (ssn.length() != 9) {
            return false;
        }
        try {
            int sum = 0;
            for (int i = 0; i < ssn.length() - 1; i++) {
                if (i % 2 == 0) {
                    sum += (validateChar(ssn.charAt(i)) * 3);
                } else {
                    sum += (validateChar(ssn.charAt(i)) * 7);
                }

            }
            return validateChar(ssn.charAt(8))==sum%10;

        } catch (IllegalArgumentException iae) {
            return false;
        }
    }

    public int validateChar(char c){
        int numberC = Character.getNumericValue(c);
        if (numberC>=0 && numberC<10){
            return numberC;
        } else {
            throw new IllegalArgumentException("nem számjegy: " +c);
        }

    }

}
