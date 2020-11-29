package abstractclass.gamecharacter;

public class Point {
    private final long x;
    private final long y;

    public Point(long x, long y) {
        this.x = x;
        this.y = y;
    }

    public long distance(Point otherPoint){
        double result=Math.sqrt(Math.pow(x-otherPoint.x,2)+Math.pow(y-otherPoint.y,2));
        return Math.round(result);
    }

    public long getX() {
        return x;
    }

    public long getY() {
        return y;
    }
}
