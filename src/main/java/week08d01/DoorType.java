package week08d01;

public enum DoorType {
    OPEN{
        @Override
        DoorType keyRotate() {
            return CLOSED;
        }
    },
    CLOSED{
        @Override
        DoorType keyRotate() {
            return OPEN;
        }
    };

    abstract DoorType keyRotate();

    public boolean isOpen(Door door) {
        return door.getTypeOfDoor() == OPEN;
    }
}
