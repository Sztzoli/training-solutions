package week11d03;

import java.util.*;

public class CharCounter {

    public static void main(String[] args) {
        System.out.println(countChars(new String[]{"abc", "cba", "ab"}));
    }
    public static int countChars(String[] chars) {
        int result = 0;
        if(chars.length>0) {
            Set<Character> first = new HashSet<>();
            for (char c : chars[0].toCharArray()) {
                first.add(c);
            }
            for (int i = 1; i < chars.length; i++) {
                Set<Character> next = new HashSet<>();
                for (char c : chars[i].toCharArray()) {
                    next.add(c);
                }
                first.retainAll(next);
            }
            result = first.size();
        }
        return result;
    }


    public int countChars1(String[] chars) {
        char[] array = chars[0].toCharArray();
        List<Character> characterList = convertToList(array);
        List<Character> afterIterate = iterate(characterList, chars);

        return afterIterate.size();
    }

    private List<Character> convertToList(char [] array) {
        List<Character> list = new ArrayList<>();
        for (char element : array) {
            list.add(element);
        }
        return list;
    }

    private List<Character> iterate(List<Character> characterList, String[] array){
        List<Character> list = new ArrayList<>(characterList);
        for (String word: array) {
            Iterator<Character> iterator = list.iterator();
            while (iterator.hasNext()){
                char actual = iterator.next();
                if (word.indexOf(actual)==-1) {
                    iterator.remove();
                }
            }
        }
        return list;
    }

}
