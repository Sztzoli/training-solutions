package references.parameters;

public class ReferencesMain {
    public static void main(String[] args) {
        Person person1;
        Person person2;

        person1=new Person("János",20);
        person2=person1;
        System.out.println(person1);
        System.out.println(person2);

        person2.setName("Géza");
        System.out.println(person1);
        System.out.println(person2);

        int a;
        int b;
        a=24;
        b=a;
        b++;

        System.out.println(a);
        System.out.println(b);

        person2=new Person("Ferenc",60);
        System.out.println(person1);
        System.out.println(person2);


    }
}
