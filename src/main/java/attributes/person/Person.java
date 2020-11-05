package attributes.person;

public class Person {
    private String name;
    private String identificationCard;
    private Address address;

    public Person(String name, String identificationCard, Address address) {
        this.name = name;
        this.identificationCard = identificationCard;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getIdentificationCard() {
        return identificationCard;
    }

    public String personToString() {
        return getName() +" "+getIdentificationCard()+" "+getAddress().addressToString() ;
    }

    public Address getAddress() {
        return address;
    }

    public void moveTo(Address address){
        this.address=address;
    }
}
