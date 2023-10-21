package edu.hw3;

import org.junit.jupiter.api.Test;
import java.util.TreeMap;
import static org.assertj.core.api.Assertions.assertThat;

public class NullTreeMapTest {
    @Test
    void testTreeMapContainsNullKey() {
        TreeMap<String, String> treeMap = new NullTreeMap<>();

        treeMap.put(null, "test");

        assertThat(treeMap.containsKey(null)).isTrue();
    }
}
