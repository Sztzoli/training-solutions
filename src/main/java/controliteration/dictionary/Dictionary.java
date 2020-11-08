package controliteration.dictionary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class Dictionary {

    private List<DictionaryItem> dictionaryItems=new ArrayList<>();

    public void addItem(String word, List<String> translations) {
        boolean isFound=false;
        for (DictionaryItem dictionaryItem: dictionaryItems ) {
            if (dictionaryItem.getWord().equals(word)) {
                dictionaryItem.addTranslations(translations);
                isFound=true;
            }
        }
        if (!isFound) {
            dictionaryItems.add(new DictionaryItem(word,translations));
        }
    }


    public List<String> findTranslations(String word) {
        for (DictionaryItem dictionaryItem: dictionaryItems) {
            if (word.equals(dictionaryItem.getWord())){
                return dictionaryItem.getTranslations();
            }
        }
        return new ArrayList<>();
    }
}
