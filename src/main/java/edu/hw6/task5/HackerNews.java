package edu.hw6.task5;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class HackerNews {
    private static final String ENDPOINT_URL = "https://hacker-news.firebaseio.com/v0";
    private static final String TOP_STORIES_RESOURCE = "/topstories.json";

    private HackerNews() {
    }

    /* <3 */
    public static long[] getHackerNewsTopStories() {
        return hackerNewsTopStories();
    }

    public static String getNewsTitle(long id) {
        return news(id);
    }

    public static long[] hackerNewsTopStories() {
        try {
            String response = sendGetRequest(ENDPOINT_URL + TOP_STORIES_RESOURCE);
            return parseStoriesIds(response);
        } catch (IOException e) {
            return new long[] {};
        }
    }

    public static String news(long id) {
        try {
            String response = sendGetRequest(ENDPOINT_URL + "/item/" + id + ".json");
            return parseNewsTitle(response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String parseNewsTitle(String input) {
        Pattern pattern = Pattern.compile("\"title\":\"([^\"]+)\"");
        Matcher matcher = pattern.matcher(input);
        matcher.find();
        return matcher.group(1);
    }

    private static long[] parseStoriesIds(String input) {
        String[] stringNumbers = input.substring(1, input.length() - 1).split(",");

        long[] longArray = new long[stringNumbers.length];
        for (int i = 0; i < stringNumbers.length; i++) {
            longArray[i] = Long.parseLong(stringNumbers[i].trim());
        }

        return longArray;
    }

    /* Есть какой-то норм ресурс про отличие URL от URI?
     * я посмотрел уже 100000000 сайтов и 99999999 видео
     * и все равно не понял
     */
    private static String sendGetRequest(String url) throws IOException {
        try (HttpClient httpClient = HttpClient.newBuilder().build()) {
            HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url))
                .GET()
                .build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (URISyntaxException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
