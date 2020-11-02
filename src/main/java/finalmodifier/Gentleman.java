package finalmodifier;

public class Gentleman {
    public static final String MESSAGE_PREFIX = "Szia ";

    public String sayHello(String name){
        return MESSAGE_PREFIX+name;
    }

    public static void main(String[] args) {
        System.out.println(new Gentleman().sayHello("Zoli"));
    }
}
