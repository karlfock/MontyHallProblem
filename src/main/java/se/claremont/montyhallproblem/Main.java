package se.claremont.montyhallproblem;

public class Main {

    public static void main(String[] args){
        Game game = Game.parse(args);
        game.start();

    }
}
