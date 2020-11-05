package attributes.person;

public class PersonMain {
    public static void main(String[] args) {
        Person person=new Person("János","LA123456",new Address("HUN","Bp","Fő utca 1","1000"));
        System.out.println(person.personToString());
        person.moveTo(new Address("HUN","Érd","Fő utca 1","1043"));
        System.out.println(person.personToString());
    }
}
