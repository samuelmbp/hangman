package org.example;

public class Print {

    public void welcomeMessage(String name) {
        System.out.println("Welcome to the Hangman game " + name + "!");
        System.out.println();
    }

    public void wordToGuessMessage() {
        System.out.println("Today's word to guess is: ");
    }

    public void askPlayerForLetterInput(String name, int remainingAttempts) {
        System.out.printf("%s: Enter one letter to guess (%d attempts remaining):\n", name, remainingAttempts);
    }
}
