package classstructureattrubutes;

import java.util.Scanner;

public class Music {
    public static void main(String[] args) {
        Song song = new Song();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please add band name");
        song.band =scanner.nextLine();
        System.out.println("Please add title");
        song.title = scanner.nextLine();
        System.out.println("Please add client length");
        song.length=scanner.nextInt();

        System.out.println("band" + song.band + " title: " + song.title + " length " + song.length);
    }
}
