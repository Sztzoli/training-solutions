package methodpass.troopers;

public class Position {
    private double posX;
    private double posY;

    public Position(double posX, double posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }

    public double distanceFrom(Position position) {
        if (position==null){
            throw new IllegalArgumentException("Illegal argument null");
        }
        double result = Math.sqrt(Math.pow(posX-position.posX,2)+Math.pow(posY-position.posY,2));
        return result;
    }
}
