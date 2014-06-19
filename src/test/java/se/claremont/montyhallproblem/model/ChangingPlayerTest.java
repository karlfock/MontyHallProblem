package se.claremont.montyhallproblem.model;

import org.junit.Test;
import se.claremont.montyhallproblem.model.game.BoxesOfChoice;
import se.claremont.montyhallproblem.model.game.Host;

import static org.junit.Assert.*;

public class ChangingPlayerTest {

    @Test
    public void testGameFlowChangingPlayer() {
        ChangingPlayer player = new ChangingPlayer();

        BoxChooser host = new Host();
        BoxesOfChoice boxesOfChoice = new BoxesOfChoice();
        Box playerBox = player.chooseFrom(boxesOfChoice);
        Box tvhostBox = host.chooseFrom(boxesOfChoice);
        Box finalChoice = player.makeDecision(boxesOfChoice);

        assertEquals("The box chosen by the host is empty", tvhostBox.hasMoney(), false);
        assertFalse("The first choice is NOT same as the final choice", playerBox.hasMoney() == finalChoice.hasMoney());
    }
}
