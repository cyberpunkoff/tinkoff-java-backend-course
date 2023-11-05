package edu.hw3;

import org.junit.jupiter.api.Test;
import java.util.Iterator;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class BackwardIteratorTest {

    @Test
    void testBackwardIteratorNextElement() {
        Iterator<Integer> backwardIterator = new BackwardIterator<>(List.of(1, 2, 3));

        assertThat(backwardIterator).toIterable().containsExactlyElementsOf(List.of(3, 2, 1));
    }

    @Test
    void testBackwardIteratorHasNextElement() {
        Iterator<Integer> backwardIterator = new BackwardIterator<>(List.of(1, 3, 4));

        assertThat(backwardIterator.hasNext()).isTrue();
    }
}
