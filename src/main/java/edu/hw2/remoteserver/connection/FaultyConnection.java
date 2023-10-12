package edu.hw2.remoteserver.connection;

import edu.hw2.remoteserver.connection.Connection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Random;

public class FaultyConnection implements Connection {
    private static final double CONNECTION_EXCEPTION_PROBABILITY = 0.4;
    private static final Random RANDOM = new Random();
    private final static Logger LOGGER = LogManager.getLogger();

    @Override
    public void execute(String command) {
        if (RANDOM.nextInt(100) < CONNECTION_EXCEPTION_PROBABILITY * 100) {
            LOGGER.error("Error during command execution!");
            throw new ConnectionException("Connection error!");
        } else {
            LOGGER.info("Command " + command + " executed successfully!");
        }
    }

    @Override
    public void close() throws Exception {
        LOGGER.info("Connection closed");
    }
}
