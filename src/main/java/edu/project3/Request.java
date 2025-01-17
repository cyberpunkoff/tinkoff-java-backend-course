package edu.project3;

import lombok.Getter;

@Getter
public final class Request {
    private final String url;
    private final String method;
    private final String resource;

    private Request(String url) {
        String[] parts = url.split(" ");
        method = parts[0];
        this.url = parts[1];
        parts = this.url.split("/");
        resource = parts[parts.length - 1];
    }

    public static Request parse(String url) {
        return new Request(url);
    }
}
