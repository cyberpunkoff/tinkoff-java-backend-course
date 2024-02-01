package edu.hw8.task1;

import java.io.IOException;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class ServerTest {
    @Test
    void serverShouldReturnCorrectResponse() {
        Client client = new Client();
        Server server = new Server(Client.SERVER_PORT);

        new Thread(() -> {
            try {
                server.serve();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();

        assertThat(client.getInsult("идиот")).isEqualTo(Insults.getInsult("идиот"));
        assertThat(client.getInsult("Нет такого")).isEqualTo(Insults.getInsult("Нет такого"));
    }
}
