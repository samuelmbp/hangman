package org.example;

import static org.example.HangmanPics.HANGMAN_PICS;
import static org.example.HangmanPics.hangmanDrawing;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private final ArrayList<Character> guessedLetters = new ArrayList<>();
    private final MaskedWord maskedWord;
    private final Print print = new Print();
    private final String word;
    private final String name;
    private final Scanner scanner = new Scanner(System.in);
    private int remainingAttempts = 7;

    public Game(WordChooser wordChooser, MaskedWord maskedWord, String name) {
        this.word = wordChooser.getRandomWord();
        this.maskedWord = maskedWord;
        this.name = name;
    }

    public void run() {
        hangmanDrawing();
        print.welcomeMessage(this.name);
        print.wordToGuessMessage();
        System.out.println(getWordToGuess());

        while(!isGameWon() && getRemainingAttempts() > 0 ) {
            print.askPlayerForLetterInput(this.name, remainingAttempts);
            Character playerLetterInput = scanner.nextLine().toUpperCase().charAt(0);
            String playerInput = guessLetter(playerLetterInput);

            if (playerInput.equals("right")) {
                if (isGameWon()) {
                    print.congratulateWinner(this.name, this.word);
                    break;
                } else {
                    print.correctGuess();
                    System.out.println(getWordToGuess());
                }
            } else {
                if (isGameLost()) {
                    break;
                } else {
                    print.wrongGuess();
                    System.out.println(getWordToGuess());
                    displayHangman();
                }
            }
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

    private boolean isGameLost() {
        if (this.remainingAttempts == 0) {
            print.gameLostMessage(this.word);
            return true;
        } else {
            return false;
        }
    }

    public boolean isGameWon() {
        for (int i = 1; i < this.word.length(); i++) {
            Character letter = this.word.charAt(i);
            if (!this.guessedLetters.contains(letter))
                return false;
        }
        return true;
    }

    private void displayHangman() {
        int index = HANGMAN_PICS.length - getRemainingAttempts();
        System.out.println(HANGMAN_PICS[index]);
    }
}