package week04d01;

public class NameChanger {
    private String fullName;

    public NameChanger(String fullName) {
        if (fullName==null || fullName.isBlank()){
            throw new IllegalArgumentException("Invalid Name: "+fullName);
        }
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void changeFirstName(String firstName){
        String[] strarray = getFullName().split(" ");
        setFullName(strarray[0]+" "+firstName);
    }
}
