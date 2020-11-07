package enumtype.unit;

import java.math.BigDecimal;
import java.util.Arrays;

public class UnitConverterMain {
    public static void main(String[] args) {
        UnitConverter unitConverter = new UnitConverter();
        System.out.println(unitConverter.convert(BigDecimal.valueOf(100),LengthUnit.MÉTER,LengthUnit.YARD));

        System.out.println(Arrays.toString(LengthUnit.values()));

        System.out.println(unitConverter.siUnits());

        System.out.println(unitConverter.getUnitSI());
    }
}
