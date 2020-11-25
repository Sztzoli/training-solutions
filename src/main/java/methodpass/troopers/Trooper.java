package methodpass.troopers;

public class Trooper {
    private String name;
    private Position position;

    public Trooper(String name) {
        if (name==null){
            throw new IllegalArgumentException("Illegal argument null");
        }
        if (name.isBlank()){
            throw new IllegalArgumentException("Name must not be empty.");
        }
        this.name = name;
        position=new Position(0,0);
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public void changePosition(Position target) {
        if (target==null){
            throw new IllegalArgumentException("Illegal argument null");
        }
        position = new Position(target.getPosX(), target.getPosY());
    }

    public double distanceFrom(Position target) {
        if (target==null){
            throw new IllegalArgumentException("Illegal argument null");
        }
        return position.distanceFrom(target);
    }
}
