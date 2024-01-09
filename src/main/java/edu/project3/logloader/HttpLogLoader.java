package edu.project3.logloader;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class HttpLogLoader implements LogLoader {
    private final String path;

    public HttpLogLoader(String path) {
        this.path = path;
    }

    @Override
    public List<String> getLogRecords() {
        return sendHttpRequest(path).lines().toList();
    }

    @Override
    public List<String> getFileNames() {
        return List.of(path.substring(path.lastIndexOf("/")));
    }

    private String sendHttpRequest(String url) {
        try (HttpClient httpClient = HttpClient.newBuilder().build()) {
            HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url))
                .GET()
                .build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (URISyntaxException | InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
