package introinheritance.employee;

public class Person {
    private String name;
    private String address;

    public Person(String name, String address) {
        if (isEmpty(name)){
            throw new IllegalArgumentException("name is wrong");
        }
        this.name = name;
        if (isEmpty(address)){
            throw new IllegalArgumentException( "address is wrong");
        }
        this.address = address;
    }

    public void migrate(String newAddress){
        if (isEmpty(newAddress)){
            throw new IllegalArgumentException("newAddress is wrong");
        }
        address=newAddress;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public boolean isEmpty(String str){
        if (str==null || str.isBlank()) {
            return true;
        }
        return false;
    }
}
