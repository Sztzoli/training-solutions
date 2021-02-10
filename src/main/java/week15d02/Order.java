package week15d02;

public class Order {

    private String delivery;
    private OrderAddress orderAddress;

    public Order(String delivery, OrderAddress orderAddress) {
        this.delivery = delivery;
        this.orderAddress = orderAddress;
    }

    public String getDelivery() {
        return delivery;
    }

    public OrderAddress getOrderAddress() {
        return orderAddress;
    }

    @Override
    public String toString() {
        return delivery + " " + orderAddress;
    }

}
