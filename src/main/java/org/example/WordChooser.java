package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WordChooser {
    private final List<String> WORDS;

    public WordChooser() {
        this.WORDS = readWordsFromFile();
    }

    private List<String> readWordsFromFile() {
        List<String> words = new ArrayList<>();
        try {
            File file = new File("src/words.txt");
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()) {
                String word = scanner.nextLine().trim();
                words.add(word);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
            e.printStackTrace();
        }

        return words;
    }

    public String getRandomWord() {
        if (WORDS.isEmpty()) return null;

        Random random = new Random();
        return WORDS.get(random.nextInt(WORDS.size()));
    }
}
