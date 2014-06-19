package se.claremont.montyhallproblem.model;

import se.claremont.montyhallproblem.model.game.BoxesOfChoice;

public class StayingPlayer extends Player {

    @Override
    protected Box decide(BoxesOfChoice boxesOfChoice){
        return picked;
    }
}
