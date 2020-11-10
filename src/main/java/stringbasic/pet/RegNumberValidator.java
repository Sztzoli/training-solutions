package stringbasic.pet;

public class RegNumberValidator {
    public boolean validator(String regNumber) {
        if (regNumber.length() != 6){
            return false;
        }
        try {

            for (int i = 0; i < regNumber.length(); i++) {
                validateChar(regNumber.charAt(i));

            }
            return true;
        } catch (IllegalArgumentException iae) {
            return false;
        }


    }

    private boolean validateChar(char c){
        int numberC = Character.getNumericValue(c);
        if (numberC>=0 && numberC<10){
            return true;
        } else {
            throw new IllegalArgumentException("nem számjegy: " +c);
        }

    }

}
