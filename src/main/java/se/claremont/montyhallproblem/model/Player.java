package se.claremont.montyhallproblem.model;

import se.claremont.montyhallproblem.model.game.BoxesOfChoice;

public abstract class Player implements BoxChooser {

    protected Box picked;
    private int correctOnes;

    @Override
    public Box chooseFrom(BoxesOfChoice boxesOfChoice){
        picked = boxesOfChoice.pickRandom();
        return picked;
    }

    public Box makeDecision(BoxesOfChoice boxesOfChoice){
        Box box = decide(boxesOfChoice);
        checkResult();
        return box;
    }

    protected abstract Box decide(BoxesOfChoice boxesOfChoice);

    private void checkResult(){
        boolean jackpot = picked.hasMoney();
        correctOnes += jackpot ? 1 : 0;
    }

    public int getCorrectOnes(){
        return correctOnes;
    }
}
