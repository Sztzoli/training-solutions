package controlselection.consonant;

public class ToConsonant {
    public static final String ABC_UPPERCASE = "AEIOU";
    public static final String ABC_LOWERCASE = "aeiou";

    public char toConsonant(char c) {
        if (ABC_UPPERCASE.contains(Character.toString(c))) {
            return ABC_UPPERCASE.indexOf(c) == ABC_UPPERCASE.length() - 1 ? ABC_UPPERCASE.charAt(0) : ABC_UPPERCASE.charAt(ABC_UPPERCASE.indexOf(c) + 1);
        } else if (ABC_LOWERCASE.contains(Character.toString(c))) {
            return ABC_LOWERCASE.indexOf(c) == (ABC_LOWERCASE.length() - 1) ? ABC_LOWERCASE.charAt(0) : ABC_LOWERCASE.charAt(ABC_LOWERCASE.indexOf(c) + 1);
        } else {
            return c;
        }
    }


}
