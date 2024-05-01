package org.example;

public class Print {

    private final String congratulationsAscii = "                                 _       \n" +
            "                                | |      \n" +
            "  ___ ___  _ __   __ _ _ __ __ _| |_ ___ \n" +
            " / __/ _ \\| '_ \\ / _` | '__/ _` | __/ __|\n" +
            "| (_| (_) | | | | (_| | | | (_| | |_\\__ \\\n" +
            " \\___\\___/|_| |_|\\__, |_|  \\__,_|\\__|___/\n" +
            "                  __/ |                  \n" +
            "                 |___/                ";


    private final String sadFace = "(•́︵•̀)";

    public void welcomeMessage(String name) {
        System.out.println("Welcome to the Hangman game " + name + "!");
        System.out.println();
    }

    public void wordToGuessMessage() {
        System.out.println("Today's word to guess is: ");
    }

    public void askPlayerForLetterInput(int remainingAttempts) {
        System.out.printf("Enter one letter to guess (%d %s remaining):\n", remainingAttempts,
                remainingAttempts > 1 ? "attempts" : "attempt");
    }

    public void congratulateWinner(String name, String word) {
        System.out.println("================================");
        System.out.println(congratulationsAscii);
        System.out.printf("Congratulations %s! You won! \nThe word was: [%s]", name, word);
        System.out.println();
    }

    public void correctGuess() {
        System.out.println("Correct guess! The letter is in the word.");
    }

    public void wrongGuess() {
        System.out.println("Incorrect guess! The letter is not in the word.");
    }

    public void gameLostMessage(String word) {
        System.out.printf("%s Sorry, you lost! The word was: [%s].", sadFace, word);
        System.out.println();
        System.out.println("Better luck next time!");
        System.out.println();
    }
}
