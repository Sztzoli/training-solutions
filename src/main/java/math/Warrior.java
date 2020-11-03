package math;

import java.util.Random;

public class Warrior {
    private Point position;
    private String name;
    private int stamina;
    private double skill;

    private final Random rnd= new Random();

    public Warrior(String name,Point position) {
        this.name = name;
        stamina=rnd.nextInt(80)+20;
        skill=rnd.nextDouble();
        this.position=position;
    }

    public Point getPosition() {
        return position;
    }
    public void move(Warrior enemy){
        if (position.getX()!=enemy.position.getX() && position.getY()!=enemy.position.getY()) {
            position.setX((position.getX() < enemy.position.getX()) ? (position.getX() + 1) : (position.getX() - 1));
            position.setY(position.getX()<enemy.position.getY() ? position.getY()+1 : position.getY()-1);
        } else if (position.getX()!=enemy.position.getX()) {
            position.setX((position.getX() < enemy.position.getX()) ? (position.getX() + 1) : (position.getX() - 1));
        } else if (position.getY()!=enemy.position.getY()) {
            position.setY(position.getX()<enemy.position.getY() ? position.getY()+1 : position.getY()-1);
        } 


    }

    public void attack(Warrior enemy) {
        if (rnd.nextDouble()<enemy.skill && enemy.isAlive()){
            enemy.stamina-= (rnd.nextInt(3)+1);
        }
    }

    public boolean isAlive() {
        return stamina>0;
    }

    public String toString() {
        return name +" ("+position.getX()+", "+position.getY()+") "+stamina;
    }

}
