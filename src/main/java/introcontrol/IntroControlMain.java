package introcontrol;

public class IntroControlMain {
    public static void main(String[] args) {
        IntroControl introControl = new IntroControl();
        System.out.println(introControl.subtractTenIfGreeterThanTen(9));

        System.out.println(introControl.describeNumber(0));
        System.out.println(introControl.describeNumber(1));

        System.out.println(introControl.greetingToJoe("Joe"));

        System.out.println(introControl.calculateBonus(10000)+" "+introControl.calculateBonus(520000000));

        System.out.println(introControl.calculateConsumption(5674,230));

        introControl.printNumbers(5);
        introControl.printNumbersBetween(5,10);
        introControl.printNumbersBetweenAnyDirection(10,5);
        introControl.printOddNumbers(15);

    }
}
