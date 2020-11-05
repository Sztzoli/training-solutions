package attributes.bill;

public class BillMain {
    public static void main(String[] args) {
        Bill bill=new Bill();
        bill.addItem(new Item("sör1",12,300));
        bill.addItem(new Item("sör2",2,300));
        bill.addItem(new Item("sör3",3,300));
        bill.addItem(new Item("sör4",4,300));
        bill.addItem(new Item("sör5",5,300));
        bill.addItem(new Item("sör6",6,300));

        System.out.println(bill.calculateTotalPrice());
    }
}
