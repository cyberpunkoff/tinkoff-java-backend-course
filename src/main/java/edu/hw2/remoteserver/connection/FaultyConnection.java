package edu.hw2.remoteserver.connection;

import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FaultyConnection implements Connection {
    private static final double CONNECTION_EXCEPTION_PROBABILITY = 0.4;
    private static final int ONE_HUNDRED = 100;
    private static final Random RANDOM = new Random();
    private final static Logger LOGGER = LogManager.getLogger();

    @Override
    public void execute(String command) {
        if (RANDOM.nextInt(ONE_HUNDRED) < CONNECTION_EXCEPTION_PROBABILITY * ONE_HUNDRED) {
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
