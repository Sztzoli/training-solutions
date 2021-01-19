package week12d02;

public class Fence {
    private final SideType sideType;
    private final int widthOFGround;
    private final String typeOfFence;

    public Fence(SideType sideType, int widthOFGround, String typeOfFence) {
        this.sideType = sideType;
        this.widthOFGround = widthOFGround;
        this.typeOfFence = typeOfFence;
    }

    public SideType getSideType() {
        return sideType;
    }

    public int getWidthOFGround() {
        return widthOFGround;
    }

    public String getTypeOfFence() {
        return typeOfFence;
    }

    @Override
    public String toString() {
        return "Fence{" +
                "sideType=" + sideType +
                ", widthOFGround=" + widthOFGround +
                ", typeOfFence='" + typeOfFence + '\'' +
                '}';
    }
}
