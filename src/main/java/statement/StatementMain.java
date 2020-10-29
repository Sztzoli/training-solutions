package statement;

public class StatementMain {
    public static void main(String[] args) {
        int x=5+6;
        System.out.println(x);
        int y=11-x;
        System.out.println(y);
        int z=8;
        boolean b = x>y ? true : false;

        boolean c = (b==true ? true : false) || (z>5 ? true : false);

        z++;

    }
}
