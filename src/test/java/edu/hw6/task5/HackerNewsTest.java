package edu.hw6.task5;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HackerNewsTest {
    @Test
    void testGetNewsTitle_shouldReturnCorrectTitle() {
        long newsId = 37570037;
        String expected = "JDK 21 Release Notes";

        String result = HackerNews.getNewsTitle(newsId);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void testGetHackerNewsTopStories_shouldReturnIdsOfTopStories() {
        // сегодня одни topStories, а завтра другие. Потом подумаю, как написать правильно.
        // опять мокать наверное
        // ну потом в моки вкат оформим, сейчас только так...
        long[] hackerNewsIds =  HackerNews.getHackerNewsTopStories();
        assertThat(hackerNewsIds).isNotEmpty();
    }
}
