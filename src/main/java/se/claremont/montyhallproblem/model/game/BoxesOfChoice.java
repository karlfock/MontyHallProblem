package se.claremont.montyhallproblem.model.game;

import se.claremont.montyhallproblem.Constants;
import se.claremont.montyhallproblem.MontyHallException;
import se.claremont.montyhallproblem.model.Box;
import se.claremont.montyhallproblem.model.Boxes;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class BoxesOfChoice {
    private List<Box> boxes;

    public BoxesOfChoice() {
        boxes = new ArrayList<>();
        Random random = new Random();
        int boxWithMoney = random.nextInt(Constants.NUMBER_OF_BOXES);
        for (int i = 0; i < Constants.NUMBER_OF_BOXES; i++) {
            boolean hasMoney = boxWithMoney == i;
            boxes.add(i, hasMoney ? Boxes.newMoneyBox() : Boxes.newBlankBox());
        }
    }

    public Box pickRandom() {
        Random random = new Random();
        int index = random.nextInt(boxes.size());
        return pick(index);
    }

    public Box pick(int number) {
        Box box = boxes.remove(number);
        return box;
    }

    // package access: this method is only accessible for Host
    Box pickBlank() {
        for (int i = boxes.size() - 1; i >= 0; i--) {
            Box box = boxes.get(i);
            if (!box.hasMoney()) {
                return pick(i);
            }
        }
        return null;
    }

    public Box pickRemaining() {
        if (boxes.size() != 1) {
            throw new MontyHallException("game is not finished, please open more boxes");
        }
        return pick(0);
    }
}
