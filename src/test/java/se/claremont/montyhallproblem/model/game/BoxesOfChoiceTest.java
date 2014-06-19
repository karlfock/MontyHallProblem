package se.claremont.montyhallproblem.model.game;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import se.claremont.montyhallproblem.MontyHallException;
import se.claremont.montyhallproblem.model.*;

import java.util.ArrayList;
import java.util.List;


public class BoxesOfChoiceTest {

    private List<Box> getBoxList(Box box1, Box box2, Box box3) {
        List<Box> boxList = new ArrayList<>();
        boxList.add(box1);
        boxList.add(box2);
        boxList.add(box3);

        return boxList;
    }

    @Test
    public void testCreation() {
        BoxesOfChoice boxes = new BoxesOfChoice();

        int blankBoxes = 0;
        int moneyBoxes = 0;

        Box box1 = boxes.pick(0);
        Box box2 = boxes.pick(0);
        Box box3 = boxes.pick(0);

        for(Box box: getBoxList(box1, box2, box3)) {
            if(box.hasMoney()) {
                moneyBoxes++;
            } else {
                blankBoxes++;
            }
        }

        assertEquals("There should be 1 money box", moneyBoxes, 1);
        assertEquals("There should be 2 blank boxes", blankBoxes, 2);
    }


    @Test
    public void testGameFlow() {
        BoxesOfChoice boxes = new BoxesOfChoice();

        int blankBoxes = 0;
        int moneyBoxes = 0;

        Box playerChoice = boxes.pickRandom();
        Box hostChoice = boxes.pickBlank();
        Box lastBox = boxes.pickRemaining();

        for(Box box: getBoxList(playerChoice, hostChoice, lastBox)) {
            if(box.hasMoney()) {
                moneyBoxes++;
            } else {
                blankBoxes++;
            }
        }

        assertEquals("There should be 1 money box", moneyBoxes, 1);
        assertEquals("There should be 2 blank boxes", blankBoxes, 2);
    }

    @Test
    public void testPickBlank() {
        BoxesOfChoice boxes = new BoxesOfChoice();

        Box box = boxes.pickBlank();

        assertEquals("The box should be blank", box.hasMoney(), false);
    }

    @Test(expected=MontyHallException.class)
    public void testPickRemaining() {
        BoxesOfChoice boxes = new BoxesOfChoice();

        Box playerChoice = boxes.pickRandom();
        Box hostChoice = boxes.pickBlank();
        Box lastBox = boxes.pickRemaining();

        Box noBoxLeft = boxes.pickRemaining();
    }

}
