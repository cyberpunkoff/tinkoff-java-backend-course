package edu.project3;

import picocli.CommandLine;

@SuppressWarnings("HideUtilityClassConstructor")
public class Main {
    public static void main(String[] args) {
        new CommandLine(new LogAnalyzer()).execute(args);
    }
}
