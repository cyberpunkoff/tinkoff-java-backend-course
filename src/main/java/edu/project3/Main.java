package edu.project3;

import picocli.CommandLine;

public class Main {
    public static void main(String[] args) {
        new CommandLine(new LogAnalyzer()).execute(args);
    }
}
