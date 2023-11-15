package edu.project3.logloader;

import java.net.http.HttpClient;
import java.util.List;

public class HttpLogLoader implements LogLoader {
    private final String path;
    public HttpLogLoader(String path) {
        this.path = path;
    }

    @Override
    public List<String> getLogRecords() {
        return null;
    }

    private String sendHttpRequest() {
        HttpClient httpClient = new HttpClient.newHttpClient();
    }
}
