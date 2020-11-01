package arraylist;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Capsules {
    private List<String> list= new ArrayList<>();


   public void addLast(String a){
       list.add(a);
   }

   public void addFirst(String a){
       list.add(0,a);
   }

   public void removeFirst(){
       list.remove(0);
   }

   public void removeLast(){
       list.remove(list.size()-1);
   }

   public List<String> getColors(){
       return list;
   }

    public static void main(String[] args) {
        Capsules capsules= new Capsules();
        capsules.addFirst("fekete");
        capsules.addLast ("kék");
        capsules.addLast ("piros");
        capsules.addFirst ("kék");
        capsules.addLast ("fehér");
        capsules.addLast ("zöld");

        System.out.println(capsules.getColors().toString());

        capsules.removeFirst();
        capsules.removeLast();

        System.out.println(capsules.getColors().toString());
        List<String> list1=capsules.getColors();
        list1.clear();
        System.out.println(list1.toString());
        System.out.println(capsules.getColors().toString() );
        System.out.println(list1.toString());


    }

}
