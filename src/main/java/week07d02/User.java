package week07d02;

public interface User {

    String getUserName();
    String getFirstName();
    String getLastName();
    String getFullName();

    static User of(User user) {
        return user;

    }


}
