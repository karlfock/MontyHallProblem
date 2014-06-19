package se.claremont.montyhallproblem.model;

public class Boxes {

    public static Box newBlankBox(){
        return new BlankBox();
    }

    public static Box newMoneyBox(){
        return new MoneyBox();
    }


    private static class BlankBox implements Box{

        @Override
        public boolean hasMoney() {
            return false;
        }
    }

    private static class MoneyBox implements Box {

        @Override
        public boolean hasMoney() {
            return true;
        }

    }
}
