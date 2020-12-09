package week07d02;

public class Main {

    public static void main(String[] args) {
       User user = User.of(new UserImpl("zed","zoltán", "Bene"));
        System.out.println(user.getFullName());
    }
}
