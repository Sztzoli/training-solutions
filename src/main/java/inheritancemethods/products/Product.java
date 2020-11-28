package inheritancemethods.products;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Product {
    private String name;
    private BigDecimal unitWeight;
    private int numberOfDecimals;

    public Product(String name, BigDecimal unitWeight) {
        this.name = name;
        this.unitWeight = unitWeight;
        numberOfDecimals =2;
    }

    public Product(String name, BigDecimal unitWeight, int numberOfDecimal) {
        this(name, unitWeight);
        this.numberOfDecimals = numberOfDecimal;
    }

    public BigDecimal totalWeight(int pieces){
        BigDecimal totalWeight= unitWeight.multiply(BigDecimal.valueOf(pieces));
        return totalWeight.setScale(numberOfDecimals, RoundingMode.HALF_UP);
    }

    public String getName() {
        return name;
    }

    public BigDecimal getUnitWeight() {
        return unitWeight;
    }

    public int getNumberOfDecimals() {
        return numberOfDecimals;
    }
}
