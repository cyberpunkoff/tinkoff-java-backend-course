package edu.hw2.remoteserver.connectionmanager;

import edu.hw2.remoteserver.connection.Connection;
import edu.hw2.remoteserver.connection.FaultyConnection;

public class FaultyConnectionManager implements ConnectionManager {
    private Long seed;

    public FaultyConnectionManager() {
    }

    public FaultyConnectionManager(long seed) {
        this.seed = seed;
    }

    @Override
    public Connection getConnection() {
        if (seed != null) {
            return new FaultyConnection(seed);
        } else {
            return new FaultyConnection();
        }
    }
}
