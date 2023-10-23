package edu.hw2.remoteserver.connectionmanager;

import edu.hw2.remoteserver.connection.Connection;
import edu.hw2.remoteserver.connection.FaultyConnection;
import edu.hw2.remoteserver.connection.StableConnection;
import java.util.Random;

public class DefaultConnectionManager implements ConnectionManager {
    private static final double BAD_CONNECTION_PROBABILITY = 0.2;
    private static final int ONE_HUNDRED = 100;
    private static final Random RANDOM = new Random();

    @Override
    public Connection getConnection() {
        if (RANDOM.nextInt(ONE_HUNDRED) < BAD_CONNECTION_PROBABILITY * ONE_HUNDRED) {
            return new FaultyConnection();
        } else {
            return new StableConnection();
        }
    }
}
