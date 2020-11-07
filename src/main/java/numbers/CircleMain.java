package numbers;



import java.util.Scanner;

public class CircleMain {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Circle[] circles= new Circle[2];
        for (int i = 0; i < circles.length; i++) {
            System.out.println("Adj meg egy átmérőt");
            circles[i]=new Circle(Integer.parseInt(scanner.nextLine()));
        }
        for (int i = 0; i < circles.length; i++) {
            System.out.println((i+1)+". kör- kerület:"+circles[i].perimeter()+" terület: "+ circles[i].area());
        }
        System.out.println((3.14*10));

    }
}
