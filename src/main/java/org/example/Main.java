package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        WordChooser wordChooser = new WordChooser();
        MaskedWord masked = new MaskedWord();
        ArrayList<Character> characters = new ArrayList<>(Arrays.asList('S', 'E', 'N', 'E', 'O'));

        String word = wordChooser.getRandomWord();
        System.out.println(masked.getMaskedWord(word, characters));
    }
}