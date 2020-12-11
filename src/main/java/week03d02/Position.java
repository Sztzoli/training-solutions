package week03d02;

import java.util.ArrayList;
import java.util.List;

public class Position {
    private String name;
    private int bonus;

    public Position(String name, int bonus) {
        this.name = name;
        this.bonus = bonus;
    }

    public String getName() {
        return name;
    }

    public int getBonus() {
        return bonus;
    }



    @Override
    public String toString() {

        return  name+ " " + bonus ;
    }

    public static void main(String[] args) {
        List<Position> positions = new ArrayList<>();
        positions.add(new Position("CEO", 200_000));
        positions.add(new Position("Manegar", 180_000));
        positions.add(new Position("assistant", 120_000));
        positions.add(new Position("worker", 100_000));


        for (Position position: positions
             ) {
            if (position.getBonus()>150_00){
                System.out.println(position);
            }
        }




    }
}
