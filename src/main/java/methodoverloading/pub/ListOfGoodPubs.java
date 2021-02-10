package methodoverloading.pub;


import java.util.List;

public class ListOfGoodPubs {
    private final List<Pub> goodPubs;


    public ListOfGoodPubs(List<Pub> goodPubs){
        if (goodPubs==null || goodPubs.isEmpty()) {
            throw new IllegalArgumentException("Pub list is empty!");
        }
        this.goodPubs=goodPubs;
    }
    public Pub findTheBest(){

        int min = goodPubs.get(0).getOpenFrom().timeWithSecond();
        int index = 0;
        for (int i = 1; i < goodPubs.size(); i++) {
            int temp=goodPubs.get(i).getOpenFrom().timeWithSecond();
            if(temp<min){
                min=temp;
                index=i;
            }
        }
        return goodPubs.get(index);
    }
}
