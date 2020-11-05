package math;

public class Game {



    public static void main(String[] args) {
        Warrior nightElf = new Warrior("Tyrande Whisperwind", new Point(10, 0));
        Warrior ork = new Warrior("Thrall", new Point(20, 0));




        for (int round = 1; nightElf.isAlive() && ork.isAlive()  ; round++) {
            if (nightElf.getPosition().distance(ork.getPosition())!=0){
                nightElf.move(ork);
                ork.move(nightElf);
                round++;
            } else {
                nightElf.attack(ork);
                if (ork.isAlive()){
                    ork.attack(nightElf);
                }
            }
            System.out.println(round+". kör:");
            round++;
            System.out.println(nightElf.toString());
            System.out.println(ork.toString());



        }





        System.out.println(nightElf.isAlive() ? "Winner: "+nightElf.toString() : "Winner: " +ork.toString());



    }
}
