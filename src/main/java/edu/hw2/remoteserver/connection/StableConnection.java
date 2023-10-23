package edu.hw2.remoteserver.connection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StableConnection implements Connection {
    private final static Logger LOGGER = LogManager.getLogger();

    @Override
    public void execute(String command) {
        LOGGER.info("Command " + command + " executed successfully!");
    }

    @Override
    public void close() throws Exception {
        LOGGER.info("Connection closed");
    }
}
