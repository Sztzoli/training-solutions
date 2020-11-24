package week05d02;

public class ChangeLetter {
    private final String VOWELS = "aeiouAEIOU";

    public String changeVowels(String str){

        String temp=str;
        for (int i = 0; i < str.length(); i++) {
            for (char c: VOWELS.toCharArray()) {
                if (c==str.charAt(i)){
                    temp=temp.replace(c,'*');
                }
            }
        }
        return temp;
    }
}
