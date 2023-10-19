package edu.hw2.remoteserver.connectionmanager;

import edu.hw2.remoteserver.connection.Connection;
import edu.hw2.remoteserver.connection.FaultyConnection;

public class FaultyConnectionManager implements ConnectionManager {
    @Override
    public Connection getConnection() {
        return new FaultyConnection();
    }
}