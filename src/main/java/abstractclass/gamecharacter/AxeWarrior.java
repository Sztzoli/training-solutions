package abstractclass.gamecharacter;

import java.util.Random;

public class AxeWarrior extends Character{

    public AxeWarrior(Point position,  Random rnd) {
        super(position, rnd);
    }

    private int getActualSecondaryDamage() {
        return  (int)Math.random()*getActualPrimaryDamage()*2;
    }

    @Override
    public void secondaryAttack(Character enemy) {
        if (getPosition().distance(enemy.getPosition())<2) {
            hit(enemy,getActualSecondaryDamage());
        }
    }
}
