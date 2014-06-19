package se.claremont.montyhallproblem.model.game;

import se.claremont.montyhallproblem.model.Box;
import se.claremont.montyhallproblem.model.BoxChooser;

public class Host implements BoxChooser {

    @Override
    public Box chooseFrom(BoxesOfChoice boxesOfChoice) {
        return boxesOfChoice.pickBlank();
    }
}
