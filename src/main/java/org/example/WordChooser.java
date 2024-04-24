package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class WordChooser {
    private final ArrayList<String> WORDS = new ArrayList<>(Arrays.asList("NOLOGY", "ENGINEER", "MUSICIAN", "SINGER"));

    public String getRandomWord() {
        Random random = new Random();
        return WORDS.get(random.nextInt(WORDS.size()));
    }
}
