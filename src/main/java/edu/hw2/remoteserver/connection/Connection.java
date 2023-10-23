package edu.hw2.remoteserver.connection;

public interface Connection extends AutoCloseable {
    void execute(String command);
}
