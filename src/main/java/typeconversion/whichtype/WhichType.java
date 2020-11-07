package typeconversion.whichtype;

import java.util.ArrayList;
import java.util.List;

public class WhichType {
    public List<Type> whichType(String s) {
        List<Type> types = new ArrayList<>();
        for (Type type : Type.values()) {
            long a = Long.parseLong(s);
            if (a > type.getMin() && a < type.getMax()) {
                types.add(type);
            }
        }
        return types;
    }
}
