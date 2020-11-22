package immutable.satellite;

public class Satellite {

private final String registerIdent;

private CelestialCoordinates destinationCoordinates;

    public Satellite(CelestialCoordinates celestialCoordinates, String registerIdent) {
        if (isEmpty(registerIdent)){

            throw new IllegalArgumentException("Register ident must not be empty!");
        }
        this.registerIdent = registerIdent;
        this.destinationCoordinates = celestialCoordinates;
    }

    public void modifyDestination(CelestialCoordinates diff) {
        destinationCoordinates = new CelestialCoordinates(destinationCoordinates.getX() + diff.getX(), destinationCoordinates.getY()+diff.getY(), destinationCoordinates.getZ()+diff.getZ());
    }

    public String getRegisterIdent() {
        return registerIdent;
    }

    public String toString(){
        return registerIdent+": "+ destinationCoordinates;
    }

    private boolean isEmpty(String registerIdent){
        return registerIdent == null || registerIdent.isBlank();
    }
}
