package methodchain;

import java.util.List;

public class NavigationPoint {
    private int actualDistance;
    private int actualAzimut;

    public NavigationPoint(int actualDistance, int actualAzimut) {
        this.actualDistance = actualDistance;
        this.actualAzimut = actualAzimut;
    }

    public int getActualDistance() {
        return actualDistance;
    }

    public int getAtualAzimut() {
        return actualAzimut;
    }

    @Override
    public String toString() {
        return String.format("distance: %d azimut: %d",actualDistance, actualAzimut);
    }
}
