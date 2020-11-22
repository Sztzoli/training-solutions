package methodstructure.pendrives;

public class Pendrive {
    private String name;
    private int capacity;
    private int price;

    public Pendrive(String name, int capacity, int price) {
        this.name = name;
        this.capacity = capacity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getPrice() {
        return price;
    }

    public double getPricePerCapacity(){
        return price/(double) capacity;
    }

    @Override
    public String toString() {
        return "Pendrive{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                ", price=" + price +
                '}';
    }

    public void risePrice(int i) {
        int amountOfRise=price*i/100;
        price=price+amountOfRise;
    }


    public int comparePricePerCapacity(Pendrive pendrive2) {
        int i=0;
        if (getPricePerCapacity() > pendrive2.getPricePerCapacity()){
            i=1;
        } else if (getPricePerCapacity() < pendrive2.getPricePerCapacity()){
            i=-1;
        }
        return i;
    }

    public boolean cheaperThan(Pendrive pendrive2) {
        return price<pendrive2.price;
    }

}
