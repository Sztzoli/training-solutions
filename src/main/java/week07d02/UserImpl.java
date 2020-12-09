package week07d02;

public class UserImpl implements User{
    private String userName;
    private String firstName;
    private String lastName;
    private String fullName;

    public UserImpl(String userName, String firstName, String lastName) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        fullName= firstName +" "+ lastName;
    }



    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String getFullName() {
        return fullName;
    }


}
