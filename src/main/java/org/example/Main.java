package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        WordChooser wordChooser = new WordChooser();
        MaskedWord masked = new MaskedWord();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");

        Game game = new Game(wordChooser, masked, scanner.nextLine());
        game.run();
    }
}