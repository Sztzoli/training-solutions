package immutable.satellite;

public class CelestialCoordinates {
    private final int x;
    private final int y;
    private final int z;

    public CelestialCoordinates(Integer x, Integer y, Integer z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }



    public String toString() {
        return String.format("CelestialCoordinates: x=%d, y=%d, z=%d", x, y, z);

    }
}
