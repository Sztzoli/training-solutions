package enumtype.unit;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;



public class UnitConverter {

    private List<LengthUnit> unitSI=siUnits();

    public List<LengthUnit> getUnitSI() {
        return unitSI;
    }

    public BigDecimal convert(BigDecimal length, LengthUnit source, LengthUnit target) {
          return length.multiply(new BigDecimal(source.getMmUnit()))
                  .divide(new BigDecimal(target.getMmUnit()),4, RoundingMode.HALF_UP);
    }

    public List<LengthUnit> siUnits() {
        List<LengthUnit> lengthUnits = new ArrayList<>();
        for (LengthUnit lengthUnit : LengthUnit.values()) {
            if (lengthUnit.isSI()) {
                lengthUnits.add(lengthUnit);
            }
        }
        return lengthUnits;
    }
}
