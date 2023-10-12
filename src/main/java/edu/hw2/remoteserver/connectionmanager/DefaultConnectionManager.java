package edu.hw2.remoteserver.connectionmanager;

import edu.hw2.remoteserver.connection.FaultyConnection;
import edu.hw2.remoteserver.connection.StableConnection;
import edu.hw2.remoteserver.connection.Connection;
import java.util.Random;

public class DefaultConnectionManager implements ConnectionManager {
    private static final double BAD_CONNECTION_PROBABILITY = 0.2;
    private static final Random RANDOM = new Random();

    @Override
    public Connection getConnection() {
        if (RANDOM.nextInt(100) < BAD_CONNECTION_PROBABILITY * 100) {
            return new FaultyConnection();
        } else {
            return new StableConnection();
        }
    }
}
