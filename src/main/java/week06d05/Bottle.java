package week06d05;

public class Bottle {
    private BottleType type;
    private int filledUntil;

    public Bottle(BottleType type) {
        this.type = type;
        this.filledUntil = 0;
    }

    static public Bottle of(BottleType type) {
        return new Bottle(type);
    }

    public Bottle fill(int fillAmount) {
        if(type.overFlow(filledUntil+fillAmount)){
            throw new IllegalArgumentException("overflow");
        }
        filledUntil += fillAmount;
        return this;
    }

    public BottleType getType() {
        return type;
    }

    public int getFilledUntil() {
        return filledUntil;
    }
}
