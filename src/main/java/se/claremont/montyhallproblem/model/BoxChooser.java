package se.claremont.montyhallproblem.model;

import se.claremont.montyhallproblem.model.game.BoxesOfChoice;

public interface BoxChooser {
    public Box chooseFrom(BoxesOfChoice boxesOfChoice);
}
