package org.example;

import static org.example.HangmanPics.HANGMAN_PICS;
import static org.example.HangmanPics.hangmanDrawing;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private final ArrayList<Character> guessedLetters = new ArrayList<>();
    private final MaskedWord maskedWord;
    private final WordChooser wordChooser;
    private final Print print = new Print();
    private String word;
    private final String name;
    private final Scanner scanner = new Scanner(System.in);
    private int remainingAttempts = 7;

    public Game(WordChooser wordChooser, MaskedWord maskedWord, String name) {
        this.wordChooser = wordChooser;
        this.word = wordChooser.getRandomWord();
        this.maskedWord = maskedWord;
        this.name = name;
    }

    public void run() {
        hangmanDrawing();
        print.welcomeMessage(this.name);
        print.wordToGuessMessage();
        // TODO: Remove the below line of code
        System.out.println(this.word);
        System.out.println(getWordToGuess());

        while(!isGameWon() && getRemainingAttempts() > 0 ) {
            print.askPlayerForLetterInput(remainingAttempts);
            String input = scanner.nextLine().toLowerCase();

            if (input.isEmpty()) {
                System.out.println("You did not enter anything. Please enter a letter.");
                continue;
            }

            Character playerLetterInput = input.charAt(0);

            if (!Character.isLetter(playerLetterInput)) {
                System.out.println("Invalid input. Please enter a valid letter!");
                continue;
            }

            if (guessedLetters.contains(playerLetterInput)) {
                System.out.println("Letter has already been guessed. Try a new letter.");
                continue;
            }

            boolean correctGuess = guessLetter(playerLetterInput);

            if (correctGuess) {
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

        playAgain();
    }

    private  String getWordToGuess() {
        return this.maskedWord.getMaskedWord(this.word, guessedLetters);
    }

    private int getRemainingAttempts() {
        return this.remainingAttempts;
    }

    private boolean guessLetter(Character letter) {
      if (this.word.indexOf(letter) != - 1) {
            guessedLetters.add(letter);
            return true;
        } else {
            this.remainingAttempts--;
            return false;
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

    private boolean isGameWon() {
        for (int i = 0; i < this.word.length(); i++) {
            Character letter = this.word.charAt(i);
            if (!this.guessedLetters.contains(letter))
                return false;
        }
        return true;
    }

    private void playAgain() {
        String playAgain = "";
        while(!playAgain.equals("yes")) {
            System.out.print("Would you like to play again? (yes/no): ");
            playAgain = scanner.nextLine().toLowerCase();
            if (playAgain.equals("yes")) {
                resetGame();
                run();
            } else {
                System.out.println("Thank you for playing! Goodbye!");
                break;
            }
        }
    }

    private void resetGame() {
        guessedLetters.clear();
        this.remainingAttempts = 7;
        this.word = wordChooser.getRandomWord();
        System.out.println("Starting a new game...");
    }

    private void displayHangman() {
        int index = HANGMAN_PICS.length - getRemainingAttempts();
        System.out.println(HANGMAN_PICS[index]);
    }
}