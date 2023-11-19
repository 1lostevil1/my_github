package edu.hw6.Task5;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class HackerNewsTest {
    @Test
    public void hackerNewsTopStoriesTest() {
        assertThat(HackerNews.hackerNewsTopStories().length).isNotEqualTo(0);
    }

    @Test
    public void newsTest() {
        assertThat(HackerNews.news(1)).isNotNull().isNotEqualTo("");
    }
}
