package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        WordChooser wordChooser = new WordChooser();
        MaskedWord masked = new MaskedWord();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Hangman!");

        System.out.print("Before we begin, could you please tell me your name? ");
        String playerName = scanner.nextLine();

        System.out.println("Hello, " + playerName + "! Let's play Hangman!");

        Game game = new Game(wordChooser, masked, playerName);
        game.run();
    }
}