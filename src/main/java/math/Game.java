package math;

public class Game {



    public static void main(String[] args) {
        Warrior nightElf = new Warrior("Tyrande Whisperwind", new Point(10, 0));
        Warrior ork = new Warrior("Thrall", new Point(20, 0));


        int round = 1;

        for (int i = 0; i < 1; i++) {
            nightElf.move(ork);
            ork.move(nightElf);
            if (nightElf.getPosition().getX() == ork.getPosition().getX() && nightElf.getPosition().getY() == ork.getPosition().getY()) {
                i++;
            }
            System.out.println(round+". kör:");
            round++;
            System.out.println(nightElf.toString());
            System.out.println(ork.toString());
            i--;
        }

        for (int i = 0; i < 1; i++) {
            nightElf.attack(ork);
            ork.attack(nightElf);
            if (ork.isAlive() && nightElf.isAlive()){
                System.out.println(round+". kör:");
                round++;
                System.out.println(nightElf.toString());
                System.out.println(ork.toString());
                i--;
            }


        }
        System.out.println(round+". kör:");
        System.out.println(nightElf.toString());
        System.out.println(ork.toString());

        System.out.println(nightElf.isAlive() ? "Winner: "+nightElf.toString() : "Winner: " +ork.toString());



    }
}
