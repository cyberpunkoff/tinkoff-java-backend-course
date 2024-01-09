package edu.hw6.task4;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;

public class StreamChain {
    public static final String FILE_NAME = "src/main/resources/edu/hw6/out.txt";
    public static final String MESSAGE = "Programming is learned by writing programs. ― Brian Kernighan";

    void build() {
        try (OutputStream outputStream = Files.newOutputStream(Path.of(FILE_NAME));
             CheckedOutputStream checkedOutputStream = new CheckedOutputStream(outputStream, new CRC32());
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(checkedOutputStream);
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
                 bufferedOutputStream,
                 StandardCharsets.UTF_8.newEncoder()
             );
             PrintWriter printWriter = new PrintWriter(outputStreamWriter)) {
                printWriter.println(MESSAGE);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
