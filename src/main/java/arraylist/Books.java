package arraylist;

import java.util.ArrayList;
import java.util.List;

public class Books {
    private List<String> titles= new ArrayList<>();

    public List<String> getTitles() {
        return titles;
    }

    public void add(String title){
        titles.add(title);
    }

    public List<String> findAllByPrefix(String prefix) {
        List<String> a = new ArrayList<>();
        for (String title: titles
             ) {
            if (title.startsWith(prefix)){
                a.add(title);
            }
        }
        return a;
    }

    public void removeByPrefix(String prefix){
        List<String> a= new ArrayList<>();
        for (String title: titles
             ) {
            if (title.startsWith(prefix)){
                a.add(title);
            }
        }
        titles.removeAll(a);
    }
    public void removeByPrefix2(String prefix){
        for (int i = 0; i < titles.size(); i++) {
            if (titles.get(i).startsWith(prefix)){
                titles.remove(i);
            }
        }
    }


    public static void main(String[] args) {
        Books books=new Books();
        books.add("egy valaki");
        books.add("egy valami");
        books.add("egy valami");
        books.add("hátom valaki");
        books.add("egy valaki");

        System.out.println(books.getTitles().toString());

        System.out.println(books.findAllByPrefix("egy").toString());
        //books.removeByPrefix2("egy"); mivel ha törlünk csökken az index ,és ha egymás mellet prefix megegyezik akkor nem törlödik a második
        books.removeByPrefix("egy");
        System.out.println(books.getTitles().toString());
    }

}
