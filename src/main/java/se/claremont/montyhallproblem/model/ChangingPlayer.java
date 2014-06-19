package se.claremont.montyhallproblem.model;

import se.claremont.montyhallproblem.model.game.BoxesOfChoice;

public class ChangingPlayer extends Player {

    @Override
    protected Box decide(BoxesOfChoice boxesOfChoice) {
        picked = boxesOfChoice.pickRemaining();
        return picked;
    }
}
