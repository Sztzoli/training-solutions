package week03d04;

public class PhoneParser {

    public static final String SEPARATOR = "-";
    public static final int INDEX_OF_PARAMETER = 0;
    public static final int INDEX_OF_NUMBER = 1;

    public Phone parse(String str) {
       String[] parts  = str.split(SEPARATOR);
       String prefix = parts[INDEX_OF_PARAMETER];
       String number = parts[INDEX_OF_NUMBER];
       return new Phone(prefix, number);
    }
}

