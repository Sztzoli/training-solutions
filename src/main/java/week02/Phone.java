package week02;

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
        Phone phone1= new Phone("valami",2);
        Phone phone2 = new Phone("valami2,",4);


        System.out.println(phone1.getName()+" "+phone1.getMem());
        System.out.println(phone2.getName()+" "+phone2.getMem());

    }
}
