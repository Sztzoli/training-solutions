package classstructureintegrate;

public class Bank {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount("12345678-12345678-00000000","John Doe",100000);
        BankAccount bankAccount1 = new BankAccount("987654321-987654321-00000000","Jack Doe",50000);

        System.out.println(bankAccount.getInfo());
        System.out.println(bankAccount1.getInfo());

        bankAccount.deposit(100000);
        bankAccount1.withdraw(25000);

        System.out.println(bankAccount.getInfo());
        System.out.println(bankAccount1.getInfo());

        bankAccount.transfer(bankAccount1,50000);

        System.out.println(bankAccount.getInfo());
        System.out.println(bankAccount1.getInfo());
    }
}
