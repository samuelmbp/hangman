package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    final private ArrayList<Character> guessedLetters = new ArrayList<>();
    final private MaskedWord maskedWord;
    final private WordChooser wordChooser;
    final private Print print = new Print();
    final private String word;
    final private String name;
    private Scanner scanner = new Scanner(System.in);
    private int remainingAttempts = 8;

    public Game(WordChooser wordChooser, MaskedWord maskedWord, String name) {
        this.wordChooser = wordChooser;
        this.maskedWord = maskedWord;
        this.name = name;
        this.word = wordChooser.getRandomWord();
    }

    public void run() {
        print.welcomeMessage(this.name);
        print.wordToGuessMessage();
        System.out.println(getWordToGuess());

            print.askPlayerForLetterInput(this.name, remainingAttempts);
            Character playerLetterInput = scanner.nextLine().toUpperCase().charAt(0);
            String playerInput = guessLetter(playerLetterInput);

            if (playerInput.equals("right")) {
                System.out.println("Good");
            } else {
                System.out.println("Not good.");
                System.out.println(getRemainingAttempts());
            }

    }

    private  String getWordToGuess() {
        return this.maskedWord.getMaskedWord(this.word, guessedLetters);
    }

    private int getRemainingAttempts() {
        return this.remainingAttempts;
    }

    private String guessLetter(Character letter) {
        if (this.word.indexOf(letter) != - 1) {
            guessedLetters.add(letter);
            return "right";
        } else {
            this.remainingAttempts--;
            return "wrong";
        }
    }
}