package week13d05;

import java.util.List;

public class TemplateTypeThree implements StringTemplate {

    @Override
    public String format(List<BillItem> items) {
        StringBuilder sb = new StringBuilder();
        for (BillItem item : items) {
            sb.append(lineFormat(item));
            sb.append("\n");
        }
        return sb.toString();
    }

    private String lineFormat(BillItem item) {
        int amount = item.getUnitPrice() * item.getNumber();
        String line = String.format("%s %d * %d = %d", item.getName(), item.getNumber(), item.getUnitPrice(), amount);
        return line;
    }


}
