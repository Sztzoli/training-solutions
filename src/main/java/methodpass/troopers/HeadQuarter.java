package methodpass.troopers;

import java.util.ArrayList;
import java.util.List;

public class HeadQuarter {
    private List<Trooper> troopers = new ArrayList<>();

    public List<Trooper> getTroopers() {
        return troopers;
    }

    public void addTrooper(Trooper trooper) {
        if (trooper==null){
            throw new IllegalArgumentException("Illegal argument null");
        }
        troopers.add(trooper);
    }

    public void moveTrooperByName(String name, Position target){
        if (name==null || target==null){
            throw new IllegalArgumentException("Illegal argument null");
        }
        moveTrooper(findTrooperByName(name),target);
    }

    public void moveClosestTrooper(Position target){
        if (target==null){
            throw new IllegalArgumentException("Illegal argument null");
        }
        moveTrooper(findClosestTrooper(target),target);
    }

    private Trooper findClosestTrooper(Position target){
        double min=troopers.get(0).distanceFrom(target);
        int index=0;
        for (int i = 0; i < troopers.size(); i++) {
            double trooperDistance = troopers.get(i).distanceFrom(target);
            if(trooperDistance < min){
                min = trooperDistance;
                index=i;
            }
        }
        return troopers.get(index);
    }

    private Trooper findTrooperByName(String name){
        for (Trooper trooper : troopers ) {
            if(name.equals(trooper.getName())){
                return trooper;
            }
        }
        throw new IllegalArgumentException();
    }

    private void moveTrooper (Trooper trooper, Position target ) {
        trooper.changePosition(target);
    }
}
