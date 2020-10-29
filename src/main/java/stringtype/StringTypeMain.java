package stringtype;

public class StringTypeMain {
    public static void main(String[] args) {

        String prefix = "Hello";
        String name = " John Doe";
        String massage= prefix + name;
        massage+=444;
        System.out.println(massage);

        boolean c = massage.equals("Hello John Doe444") ;
        boolean b = massage.equals("Hello John Doe");

        String doubelempty=""+"";
        System.out.println(doubelempty.length());

        String valami="Abcde";
        System.out.println(valami.length());
        System.out.println(valami.charAt(0) +", " + valami.charAt(2));
        System.out.println(valami.substring(0,3));


    }
}
