package enumtype.unit;

public enum LengthUnit {
    MILLIMÉTER(true,1),
    CENTIMÉTER(true,10),
    MÉTER(true,1000),
    YARD(false,914.4),
    FOOT(false,304.8),
    INCH(false,25.4);

    private final boolean isSI;
    private final double mmUnit;

    LengthUnit(boolean isSI, double mmUnit) {
        this.isSI = isSI;
        this.mmUnit = mmUnit;
    }

    public boolean isSI() {
        return isSI;
    }

    public double getMmUnit() {
        return mmUnit;
    }
}
