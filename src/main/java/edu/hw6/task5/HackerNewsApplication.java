package edu.hw6.task5;

import java.util.Arrays;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class HackerNewsApplication {
    private final static Logger LOGGER = LogManager.getLogger();

    private HackerNewsApplication() {
    }

    @SuppressWarnings("MagicNumber")
    public static void run() {
        LOGGER.info(Arrays.toString(HackerNews.hackerNewsTopStories()));
        String newsTitle = HackerNews.news(37570037);
        LOGGER.info(newsTitle);
    }
}
