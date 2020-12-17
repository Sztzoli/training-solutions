package week08d03;

import java.util.ArrayList;
import java.util.List;

public class StringLists {

    public List<String> shortestWords(List<String> words){
        List<String> shortWords = new ArrayList<>();
        int minLength = Integer.MAX_VALUE;
        for (String word : words) {
            if (word.length()<minLength){
                shortWords.clear();
                minLength = word.length();
            }
            if (word.length()==minLength) {
                shortWords.add(word);
            }
        }
        return shortWords;
    }
}
