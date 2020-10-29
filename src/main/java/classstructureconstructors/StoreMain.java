package classstructureconstructors;

public class StoreMain {
    public static void main(String[] args) {
        Store store = new Store("sör");
        Store store1 = new Store("beer");
        System.out.println(store.getProduct() +" "+store.getStick());
        System.out.println(store1.getProduct() +" "+store1.getStick());
        store.store(24);
        store1.dispatch(10);
        System.out.println(store.getProduct() +" "+store.getStick());
        System.out.println(store1.getProduct() +" "+store1.getStick());
        store.dispatch(12);
        store1.store(60);
        System.out.println(store.getProduct() +" "+store.getStick());
        System.out.println(store1.getProduct() +" "+store1.getStick());



    }
}
