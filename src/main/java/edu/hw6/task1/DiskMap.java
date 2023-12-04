package edu.hw6.task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public final class DiskMap extends HashMap<String, String> implements Map<String, String> {
    public static final String FILE_NAME = "src/main/resources/edu/hw6/task1/data.txt";
    public static final String DELIMITER = ";";

    public DiskMap() {
    }

    public void save() {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(FILE_NAME))) {
            this.forEach((key, value) -> printWriter.println(key + DELIMITER + value));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void load() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_NAME))) {
            this.clear();
            bufferedReader.lines()
                .map(line -> line.split(DELIMITER))
                .forEach(line -> this.put(line[0], line[1]));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
