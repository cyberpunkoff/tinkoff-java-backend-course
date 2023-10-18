package edu.hw2;

import edu.hw2.remoteserver.PopularCommandExecutor;
import edu.hw2.remoteserver.connection.ConnectionException;
import edu.hw2.remoteserver.connectionmanager.ConnectionManager;
import edu.hw2.remoteserver.connectionmanager.DefaultConnectionManager;
import edu.hw2.remoteserver.connectionmanager.FaultyConnectionManager;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RemoteServerTest {

    static Stream<Arguments> remoteConnectionArguments() {
        return Stream.of(
                Arguments.of(new DefaultConnectionManager(), 5),
                Arguments.of(new FaultyConnectionManager(), 10)
        );
    }

    @DisplayName("Тестирование удаленного сервера")
    @ParameterizedTest
    @MethodSource("remoteConnectionArguments")
    void remoteConnectionTest(ConnectionManager manager, int maxAttempts) {
        // given
        PopularCommandExecutor popularCommandExecutor = new PopularCommandExecutor(manager, maxAttempts);

        // when
        popularCommandExecutor.updatePackages();
        popularCommandExecutor.killSystem();

        // then
    }

    @DisplayName("Выброс исключения")
    @Test
    void faultyConnectionTest() {
        // given
        ConnectionManager faultyConnectionManager = new FaultyConnectionManager();
        PopularCommandExecutor popularCommandExecutor = new PopularCommandExecutor(faultyConnectionManager, 1);

        // when
        assertThrows(ConnectionException.class, () -> {
            for (int i = 0; i < 10; i++) {
                popularCommandExecutor.updatePackages();
            }
        });

        // then
    }
}
