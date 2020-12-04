package week06d05;

public enum BottleType {
    GLASS_BOTTLE(2),
    PET_BOTTLE(3);

    private int maximumAmount;

    BottleType(int maximumAmount) {
        this.maximumAmount = maximumAmount;
    }

    public boolean overFlow(int amount){
        if(amount>maximumAmount){
            return true;
        }
        return false;
    }

    public int getMaximumAmount() {
        return maximumAmount;
    }
}
