package edu.project3;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public final class UrlUtils {
    private UrlUtils() {
    }

    public static boolean isValidUrl(String url) {
        try {
            new URI(url).toURL();
            return true;
        } catch (MalformedURLException | URISyntaxException e) {
            return false;
        }
    }
}

