package interfaces.animal;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
    List<Animal> animals=new ArrayList<>();

    public Zoo(List<Animal> animals) {
        this.animals = animals;
    }

    public int getNumberOfLegs() {
        int sum=0;
        for (Animal animal: animals ) {
            sum+=animal.getNumberOfLegs();
        }
        return sum;
    }

    public int getNumberOfAnimals(){
        return animals.size();
    }

}
