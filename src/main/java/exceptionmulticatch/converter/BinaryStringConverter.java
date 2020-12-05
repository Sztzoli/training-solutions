package exceptionmulticatch.converter;

public class BinaryStringConverter {

    public boolean[] binaryStringToBooleanArray(String str){
        boolean[] array = new boolean[str.length()];

        try {
            for (int i = 0; i < array.length; i++) {
                array[i] = convertCharToBoolean(str.charAt(i));
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
        return array;
    }

    private boolean convertCharToBoolean(char c) {
        if (c=='0')  {
            return false;
        }
        if (c=='1') {
            return true;
        }
        throw new IllegalArgumentException();
    }

    public String booleanArrayToBinaryString(boolean[] array) {
        if (array==null || array.length==0) {
            throw new IllegalArgumentException();
        }
        StringBuilder sb = new StringBuilder();
        try {
            for (boolean b : array) {
                sb.append(convertBooleantoChar(b));
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
        return sb.toString();
    }

    private char convertBooleantoChar(boolean b) {
        if (b)  {
            return '1';
        }

            return '0';
    }
}
