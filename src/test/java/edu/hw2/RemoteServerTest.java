package edu.hw2;

import edu.hw2.remoteserver.PopularCommandExecutor;
import edu.hw2.remoteserver.connectionmanager.ConnectionManager;
import edu.hw2.remoteserver.connectionmanager.FaultyConnectionManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RemoteServerTest {
    @DisplayName("Тестирование удаленного сервера")
    @Test
    void remoteConnectionTest() {
        // given
        ConnectionManager manager = new FaultyConnectionManager();
        int maxAttempts = 10;
        PopularCommandExecutor popularCommandExecutor = new PopularCommandExecutor(manager, maxAttempts);

        // when
        popularCommandExecutor.updatePackages();

        // then
    }
}
