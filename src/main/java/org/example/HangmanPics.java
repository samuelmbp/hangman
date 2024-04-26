package org.example;

public class HangmanPics {

    private static final String asciiArt  =  " _                                             \n" +
            "| |                                            \n" +
            "| |__   __ _ _ __   __ _ _ __ ___   __ _ _ __  \n" +
            "| '_ \\ / _` | '_ \\ / _` | '_ ` _ \\ / _` | '_ \\ \n" +
            "| | | | (_| | | | | (_| | | | | | | (_| | | | |\n" +
            "|_| |_|\\__,_|_| |_|\\__, |_| |_| |_|\\__,_|_| |_|\n" +
            "                    __/ |                      \n" +
            "                   |___/               ";


    public static final String[] HANGMAN_PICS = {
            "  +---+\n  |   |\n      |\n      |\n      |\n      |\n=========",
            "  +---+\n  |   |\n  O   |\n      |\n      |\n      |\n=========",
            "  +---+\n  |   |\n  O   |\n  |   |\n      |\n      |\n=========",
            "  +---+\n  |   |\n  O   |\n /|   |\n      |\n      |\n=========",
            "  +---+\n  |   |\n  O   |\n /|\\  |\n      |\n      |\n=========",
            "  +---+\n  |   |\n  O   |\n /|\\  |\n /    |\n      |\n=========",
            "  +---+\n  |   |\n  O   |\n /|\\  |\n / \\  |\n      |\n========="
    };

    public static void hangmanDrawing() {
        System.out.println(asciiArt);
    }
}