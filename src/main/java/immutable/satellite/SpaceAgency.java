package immutable.satellite;

import java.util.ArrayList;
import java.util.List;

public class SpaceAgency {
    private List<Satellite> satellites = new ArrayList<>();

    public void registerSatellite(Satellite satellite) {
        if (satellite == null) {
            throw new NullPointerException("Parameter must not be null!");
        }
        satellites.add(satellite);
    }

    public Satellite findSatelliteByRegisterIdent(String registerIdent) {
        int i = 0;
        while (i < satellites.size()) {
            if (registerIdent.equals(satellites.get(i).getRegisterIdent())) {
                return satellites.get(i);
            }
            i++;
        }
        throw new IllegalArgumentException("Satellite with the given registration cannot be found!" + registerIdent);

    }


    public String toString() {
        return satellites.toString();
    }
}
