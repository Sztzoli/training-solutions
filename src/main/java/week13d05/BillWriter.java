package week13d05;

import java.util.List;

public class BillWriter {



    public void writeBills(List<BillItem> shoppingList, StringTemplate template) {
        System.out.println(template.format(shoppingList));
    }


    public static void main(String[] args) {
        BillItem bread = new BillItem("kenyér",3,10);
        BillItem milk = new BillItem("tej",5,20);
        List<BillItem> shoppingList = List.of(bread,milk);

        new BillWriter().writeBills(shoppingList, new TemplateTypeOne());
        new BillWriter().writeBills(shoppingList, new TemplateTypeTwo());
        new BillWriter().writeBills(shoppingList, new TemplateTypeThree());

    }
}
