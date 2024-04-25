package org.example;

import java.util.ArrayList;

public class MaskedWord {
    public String getMaskedWord(String word, ArrayList<Character> guessedLetters) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
           Character currentLetter = word.charAt(i);
           builder.append(guessedLetters.contains(currentLetter) ? currentLetter : '_');
        }

        return builder.toString();
    }
}
