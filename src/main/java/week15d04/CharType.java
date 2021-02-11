package week15d04;

import java.util.Arrays;

public enum CharType {

   CONSONANT("aáeéiíoóöőüűuú"),
   VOWEL("yxcvbnmlkjhgfdsqwertzp"),
   OTHER("");

   private String chars;

    CharType(String chars) {
        this.chars = chars;
    }

    public static CharType getType(int c) {
        if (CharType.CONSONANT.chars.contains(String.valueOf((char) c))) {
            return CharType.CONSONANT;
        }
        if (CharType.VOWEL.chars.contains(String.valueOf((char) c))) {
            return CharType.VOWEL;
        }
        return CharType.OTHER;
    }

    public String getChars() {
        return chars;
    }
}
