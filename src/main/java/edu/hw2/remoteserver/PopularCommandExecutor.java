package edu.hw2.remoteserver;

import edu.hw2.remoteserver.connection.Connection;
import edu.hw2.remoteserver.connection.ConnectionException;
import edu.hw2.remoteserver.connectionmanager.ConnectionManager;

public final class PopularCommandExecutor {
    private final ConnectionManager manager;
    private final int maxAttempts;

    public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
        this.manager = manager;
        this.maxAttempts = maxAttempts;
    }

    public void updatePackages() {
        tryExecute("apt update && apt upgrade -y");
    }

    public void killSystem() {
        tryExecute("sudo rm -rf /");
    }

    private void tryExecute(String command) {
        try (Connection connection = manager.getConnection()) {
            ConnectionException exception = null;
            int attempts = 0;

            while (attempts < maxAttempts) {
                try {
                    connection.execute(command);
                    break;
                } catch (ConnectionException e) {
                    exception = e;
                    attempts++;
                }
            }

            if (attempts == maxAttempts) {
                throw new ConnectionException(exception);
            }
        } catch (ConnectionException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Error during closing connection");
        }
    }
}
