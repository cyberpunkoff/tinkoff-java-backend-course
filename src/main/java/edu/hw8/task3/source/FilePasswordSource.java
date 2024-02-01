package edu.hw8.task3.source;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class FilePasswordSource implements PasswordSource {
    private final BlockingQueue<String> passwords;

    public FilePasswordSource(Path path) {
        try {
            List<String> lines = Files.readAllLines(path, StandardCharsets.ISO_8859_1);
            this.passwords = new ArrayBlockingQueue<>(lines.size());
            this.passwords.addAll(lines);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public FilePasswordSource(String path) {
        this(Path.of(path));
    }

    @Override
    public String nextPassword() {
        try {
            return passwords.poll(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean isEmpty() {
        return passwords.isEmpty();
    }
}
