package edu.hw2.remoteserver;

import edu.hw2.remoteserver.connection.ConnectionException;
import edu.hw2.remoteserver.connection.FaultyConnection;
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
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RemoteServerTest {
    static final long RANDOM_SEED = 1234;

    static Stream<Arguments> remoteConnectionArguments() {
        return Stream.of(
                Arguments.of(new DefaultConnectionManager(), 50),
                Arguments.of(new FaultyConnectionManager(RANDOM_SEED), 100)
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
        FaultyConnection mockedFaultyConnection = mock(FaultyConnection.class);
        FaultyConnectionManager mockedManager = mock(FaultyConnectionManager.class);
        doThrow(new ConnectionException()).when(mockedFaultyConnection).execute(anyString());
        when(mockedManager.getConnection()).thenReturn(mockedFaultyConnection);

        PopularCommandExecutor popularCommandExecutor = new PopularCommandExecutor(mockedManager, 10);

        // when

        // then
        assertThrows(ConnectionException.class, popularCommandExecutor::updatePackages);
    }
}
