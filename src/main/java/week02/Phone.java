package week02;

import java.util.Scanner;

public class Phone {
    private String name;
    private int mem;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMem() {
        return mem;
    }

    public void setMem(int mem) {
        this.mem = mem;
    }

    public Phone(String name, int mem) {
        this.name = name;
        this.mem = mem;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("name");
        String name=scanner.nextLine();
        System.out.println("mem:");
        int mem=scanner.nextInt();
        scanner.nextLine();
        Phone phone1= new Phone(name,mem);
        System.out.println("name");
        String name2=scanner.nextLine();
        System.out.println("mem:");
        int mem2=scanner.nextInt();
        Phone phone2 = new Phone(name2,mem2);


        System.out.println(phone1.getName()+" "+phone1.getMem());
        System.out.println(phone2.getName()+" "+phone2.getMem());

    }
}
