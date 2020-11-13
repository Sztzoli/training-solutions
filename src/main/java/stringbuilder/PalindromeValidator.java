package stringbuilder;

public class PalindromeValidator {

    public boolean isPalindrome(String str) {
        if (str==null){
            throw new IllegalArgumentException("Text must not be null!");
        }
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        return sb.toString().trim().toLowerCase().equals(str.trim().toLowerCase());
    }
}
