package inheritancemethods.products;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PackedProduct extends Product {
    private int packingUnit;
    private BigDecimal weightOfBox;


    public PackedProduct(String name, BigDecimal unitWeight, int numberOfDecimal, int packingUnit, BigDecimal weightOfBox) {
        super(name, unitWeight, numberOfDecimal);
        this.packingUnit = packingUnit;
        this.weightOfBox = weightOfBox;
    }

    @Override
    public BigDecimal totalWeight(int pieces) {
        BigDecimal numberOfBox=BigDecimal.valueOf(pieces).divide(BigDecimal.valueOf(packingUnit)).setScale(0, RoundingMode.UP);
        return super.totalWeight(pieces).add(numberOfBox.multiply(weightOfBox)).setScale(getNumberOfDecimals(),RoundingMode.HALF_UP);
    }

    public int getPackingUnit() {
        return packingUnit;
    }

    public BigDecimal getWeightOfBox() {
        return weightOfBox;
    }
}
