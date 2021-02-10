package week15d02;

import java.time.LocalTime;

public class OrderAddress {
    private String postCode;
    private String street;
    private String houseNumber;
    private LocalTime deliveryTime;

    public OrderAddress(String postCode, String street, String houseNumber, LocalTime deliveryTime) {
        this.postCode = postCode;
        this.street = street;
        this.houseNumber = houseNumber;
        this.deliveryTime = deliveryTime;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getStreet() {
        return street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public LocalTime getDeliveryTime() {
        return deliveryTime;
    }

    @Override
    public String toString() {
        return postCode + " " + street + " " + houseNumber + " " +deliveryTime;
    }
}
