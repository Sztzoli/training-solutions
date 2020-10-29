package statement;

import java.util.Scanner;

public class InvestMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Amount of fund:");
        int fund = scanner.nextInt();
        System.out.println("Amount of interest rate:");
        int interestRate = scanner.nextInt();
        Investment investment= new Investment(fund,interestRate);

        System.out.println(investment.getYield(50));
        System.out.println(investment.getYield(80));
        System.out.println(investment.getYield(90));

        System.out.println(investment.close(80));
        System.out.println(investment.close(90));
        System.out.println(investment.close(120));


    }
}
