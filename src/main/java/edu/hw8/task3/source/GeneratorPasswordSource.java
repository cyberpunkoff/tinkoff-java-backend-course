package edu.hw8.task3.source;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import lombok.Builder;

public class GeneratorPasswordSource implements PasswordSource {
    private final BlockingQueue<String> generatedPasswords = new LinkedBlockingQueue<>();

    private final AtomicBoolean isFinished = new AtomicBoolean();

    @Builder
    @SuppressWarnings("MagicNumber")
    public GeneratorPasswordSource(
        int passwordLength,
        boolean includeLowerCase,
        boolean includeUpperCase,
        boolean includeNumbers
    ) {
        StringBuilder result = new StringBuilder();
        if (includeLowerCase) {
            result.append("abcdefghijklmnopqrstuvwxyz");
        }

        if (includeUpperCase) {
            result.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        }

        if (includeNumbers) {
            result.append("0123456789");
        }

        new Thread(() -> {
            generatePasswords(result.toString().toCharArray(), "", passwordLength, result.length());
            isFinished.set(true);
        }).start();

        try {
            Thread.sleep(100);
            // give it some time to generate starting passwords
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String nextPassword() {
        try {
            return generatedPasswords.poll(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean isEmpty() {
        return generatedPasswords.isEmpty();
    }

    private void generatePasswords(char[] charset, String output, int n, int size) {
        if (!output.isEmpty()) {
            try {
                generatedPasswords.put(output);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        if (n == 0) {
            return;
        }
        for (int i = 0; i < size; ++i) {
            generatePasswords(charset, output + charset[i], n - 1, size);
        }
    }
}
