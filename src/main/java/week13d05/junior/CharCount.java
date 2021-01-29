package week13d05.junior;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class CharCount {

    String pattern = "[a-z]";

    public int count(String word) {
        word = word.toLowerCase();
        Set<String> charSet = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            String elem = word.substring(i,i+1);
            if (elem.matches(pattern)) {
                charSet.add(elem);
            }
        }
        return charSet.size();
    }

    public static void main(String[] args) {
        CharCount charCount = new CharCount();
        System.out.println(charCount.count("aabc"));
        System.out.println(charCount.count("aa bc"));
        System.out.println(charCount.count("aabddc"));
        System.out.println(charCount.count("aABc"));
    }
}
