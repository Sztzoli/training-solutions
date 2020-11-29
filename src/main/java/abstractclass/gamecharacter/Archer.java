package abstractclass.gamecharacter;

import java.util.Random;

public class Archer extends Character {

    private int numberOfArrow;

    public Archer(Point position,  Random rnd) {
        super(position, rnd);
        numberOfArrow = 100;
    }

    public int getNumberOfArrow() {
        return numberOfArrow;
    }

    private int getActualSecondaryDamage() {
        return getRnd().nextInt(5)+1;
    }

    private void shootingAnArrow(Character enemy){
        numberOfArrow--;
        hit(enemy, getActualSecondaryDamage());
    }


    @Override
    public void secondaryAttack(Character enemy) {
        shootingAnArrow(enemy);
    }

}
