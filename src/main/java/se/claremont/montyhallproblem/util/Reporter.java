package se.claremont.montyhallproblem.util;


public class Reporter {

    private double startTime;
    private int numberOfExecutions;

    public static Reporter start(int numberOfExecutions) {
        return new Reporter(numberOfExecutions);
    }

    private Reporter(int numberOfExecutions) {
        this.startTime = System.currentTimeMillis();
        this.numberOfExecutions = numberOfExecutions;
    }

    private void printResult(int correctGuesses1, int correctGuesses2) {
        System.out.println("\nResults:\nNumber of executions: " + numberOfExecutions);

        System.out.println("\nGuest sticks with first guess:");
        printGuessesResult(correctGuesses1);

        System.out.println("\nGuest changes his guess:");
        printGuessesResult(correctGuesses2);

        System.out.print("\nExecution finished in " + (System.currentTimeMillis() - startTime) + " ms.\n\n");
    }

    private void printGuessesResult(int correctGuesses) {
        System.out.println("*********************************************************");
        System.out.println("Correct guesses: " + correctGuesses);
        System.out.println("Percent correct guesses: " + (int)((correctGuesses*100.0f)/numberOfExecutions));
        System.out.println("*********************************************************");
    }



    public void stop(int correctGuesses1, int correctGuesses2) {
        printResult(correctGuesses1, correctGuesses2);
    }
}