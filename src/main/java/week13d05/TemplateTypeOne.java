package week13d05;

import java.util.List;

public class TemplateTypeOne implements StringTemplate {

    @Override
    public String format(List<BillItem> items) {
        StringBuilder sb = new StringBuilder();
        for (BillItem item : items) {
            sb.append(item.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
