package catalog;

import java.util.List;

public class Validators {
    public static boolean isBlank(String param){
        return param == null || param.isBlank();
    }

    public static boolean isEmpty(List<String> list) {
        return list == null || list.size() == 0;
    }
}
