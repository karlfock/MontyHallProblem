package se.claremont.montyhallproblem;
import se.claremont.montyhallproblem.model.*;
import se.claremont.montyhallproblem.model.game.BoxesOfChoice;
import se.claremont.montyhallproblem.model.game.Host;
import se.claremont.montyhallproblem.util.Reporter;

public class Game {
    private int numberOfExecutions;

    private Game(int numberOfExecutions){
        this.numberOfExecutions = numberOfExecutions;
    }

    private static Game defaultGame(){
        return new Game(Constants.DEFAULT_NUMBER_OF_EXECUTIONS);
    }

    public static Game parse(String[] args){
        try {
            int numberOfExecutions = Integer.parseInt(args[0]);
            return new Game(numberOfExecutions);
        } catch(Exception e) {
            System.out.println("Pass number of executions as first argument. 1000 is used as default.");
            return defaultGame();
        }
    }
    private int useFirstGuess() {
        return play(new StayingPlayer());
    }
    private int changeGuess() {
        return play(new ChangingPlayer());
    }

    private int play(Player player){

        BoxChooser host = new Host();
        for (int i = 0; i < this.numberOfExecutions; i++) {
            BoxesOfChoice boxesOfChoice = new BoxesOfChoice();

            // tv-guest picks a box
            Box playerBox = player.chooseFrom(boxesOfChoice);

            // tv-host shows empty box
            Box tvhostBox = host.chooseFrom(boxesOfChoice);

            player.makeDecision(boxesOfChoice);
        }
        return player.getCorrectOnes();
    }

    public void start(){
        Reporter reporter = Reporter.start(numberOfExecutions);

        int correctGuesses1 = useFirstGuess();
        int correctGuesses2 = changeGuess();


        reporter.stop(correctGuesses1, correctGuesses2);
    }
}
