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
    final private int remainingAttempts = 8;

    public Game(WordChooser wordChooser, MaskedWord maskedWord, String name) {
        this.wordChooser = wordChooser;
        this.maskedWord = maskedWord;
        this.name = name;
        this.word = wordChooser.getRandomWord();
    }

    public void run() {
        print.welcomeMessage(this.name);
        print.wordToGuessMessage();
    }
}