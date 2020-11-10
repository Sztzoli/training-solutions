package stringbasic.pet;

import java.util.ArrayList;
import java.util.List;

public class Vet {

    private List<Pet> pets = new ArrayList<>();

    public List<Pet> getPets() {
        return pets;
    }

    public void add(Pet pet) {
        if (!areEqual(pet)) {
            pets.add(pet);
        }
    }

    private boolean areEqual(Pet newpet) {
        int i=0;
        boolean contains=false;
        while (i<pets.size() && !contains){
            if (newpet.getRegNumber().equals(pets.get(i).getRegNumber())) {
                contains=true;
            }
            i++;
        }
        return contains;
    }

}
