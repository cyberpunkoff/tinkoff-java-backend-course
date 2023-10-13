package edu.project1.dictionary;

import org.jetbrains.annotations.NotNull;

public interface Dictionary {
    int MIN_WORD_LENGTH = 4;
    int MAX_WORD_LENGTH = 10;

    @NotNull String getRandomWord();
}
