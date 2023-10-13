package edu.project1.dictionary;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import org.jetbrains.annotations.NotNull;

public class TextFileDictionary implements Dictionary {
    private List<String> words;
    private static final String DEFAULT_FILENAME = "/words.txt";

    public TextFileDictionary() throws IOException, URISyntaxException {
        String fullPath = Paths.get(getClass().getResource(DEFAULT_FILENAME).toURI()).toString();
        loadWords(fullPath);
    }

    public TextFileDictionary(String filename) throws IOException {
        loadWords(filename);
    }

    public void loadWords(String filename) throws IOException {
        Path path = Paths.get(filename);
        words = Files.readAllLines(path).stream()
            .filter(word -> word.length() > MIN_WORD_LENGTH && word.length() < MAX_WORD_LENGTH)
            .map(String::toUpperCase)
            .collect(Collectors.toList());
    }

    @Override
    public @NotNull String getRandomWord() {
        int index = (int) (Math.random() * words.size());
        return words.get(index);
    }
}
