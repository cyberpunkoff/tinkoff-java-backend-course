package edu.hw8.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

public class Server {
    private static final int THREAD_AMOUNT = 4;
    private final int port;

    public Server(int port) {
        this.port = port;
    }

    public void serve() throws IOException {
        try (ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_AMOUNT);
             ServerSocket serverSocket = new ServerSocket(port)) {
            CompletableFuture.allOf(Stream.generate(() -> CompletableFuture.runAsync(
                        handleClient(serverSocket),
                        threadPool
                    ))
                    .limit(THREAD_AMOUNT)
                    .toArray(CompletableFuture[]::new))
                .join();
        }
    }

    private Runnable handleClient(ServerSocket serverSocket) {
        return () -> {
            while (true) {
                try {
                    // ой а thread-safe ли это...
                    Socket client = serverSocket.accept();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                    PrintWriter writer = new PrintWriter(client.getOutputStream(), true);

                    String keyWord = reader.readLine();
                    writer.println(Insults.getInsult(keyWord));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }
}
