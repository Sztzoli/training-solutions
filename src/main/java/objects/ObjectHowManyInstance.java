package objects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObjectHowManyInstance {
    public static void main(String[] args) {
        Book book1=new Book();
        Book book2=new Book();
        Book book3=new Book();
        Book book4=book1;
        Book book5=book1;
        Book book6=book3;
        Book book7=null;
        book4=book5;
        book5=new Book();
        book6=null;




    }


}
