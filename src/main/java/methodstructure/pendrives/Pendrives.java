package methodstructure.pendrives;



import java.util.List;

public class Pendrives {



    public Pendrive best(List<Pendrive> pendrivesList) {
        double min=pendrivesList.get(0).getPricePerCapacity();
        int index=0;
        for (int i = 1; i < pendrivesList.size(); i++) {
            if(pendrivesList.get(i).getPricePerCapacity()<min){
                min=pendrivesList.get(i).getPricePerCapacity();
                index=i;
            }
        }
        return pendrivesList.get(index);
    }

    public Pendrive cheapest(List<Pendrive> pendrivesList) {
        double min=pendrivesList.get(0).getPrice();
        int index=0;
        for (int i = 1; i < pendrivesList.size(); i++) {
            if(pendrivesList.get(i).getPrice()<min){
                min=pendrivesList.get(i).getPrice();
                index=i;
            }
        }
        return pendrivesList.get(index);
    }

    public void risePriceWhereCapacity(List<Pendrive> pendriveList, int percent, int capacity) {
        for (Pendrive pendrive : pendriveList) {
            if (capacity==pendrive.getCapacity()){
                pendrive.risePrice(percent);
            }
        }
    }
}
