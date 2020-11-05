package introconstructors;

public class RestaurantMain {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant("név", 4);
        restaurant.addMenu("sör");
        restaurant.addMenu("bor");
        restaurant.addMenu("pálinka");

        System.out.println(restaurant.getName()+" "+restaurant.getCapacity()+" "+restaurant.getMenu().toString());

    }


}
