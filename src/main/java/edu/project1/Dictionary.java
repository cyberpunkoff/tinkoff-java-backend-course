package edu.project1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Dictionary {

    private static List<String> words;

    public static void loadWords(String filename) throws IOException {
        Path path = Paths.get(filename);
        words = Files.readAllLines(path).stream()
                .filter(word -> word.length() > 4 && word.length() < 10)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    public static String getWord() {

        int index = (int) (Math.random() * words.size());
        return words.get(index);
    }
}
