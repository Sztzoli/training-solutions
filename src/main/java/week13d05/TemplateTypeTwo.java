package week13d05;

import java.util.List;

public class TemplateTypeTwo implements StringTemplate {

    @Override
    public String format(List<BillItem> items) {
        StringBuilder sb = new StringBuilder();
        String firstLine = String.format("%-20s %13s %5s %6s", "Megnevezés", "Egységár (Ft)", "Darab", "Összeg");
        sb.append(firstLine);
        sb.append("\n");
        for (BillItem item : items) {
            sb.append(lineFormat(item));
            sb.append("\n");
        }
        return sb.toString();
    }



    private String lineFormat(BillItem item) {
        int amount = item.getUnitPrice() * item.getNumber();
        String line = String.format("%-20s %13d %5d %6d", item.getName(), item.getUnitPrice(), item.getNumber(),amount);
        return line;
    }


}
