package hw3.Task7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.TreeMap;
import static org.assertj.core.api.Assertions.assertThat;

class Task7Test {

    @Test
    @DisplayName(" null test")
    void NullTest() {
        TreeMap<String, String> tree = new TreeMap<>(new MyComparator());
        tree.put("a", "a");
        tree.put("b", "b");
        tree.put(null, "n");
        tree.put("c", "c");
        assertThat(tree.containsKey(null)).isTrue();
    }

    @Test
    @DisplayName(" no null test")
    void NoNullTest() {
        TreeMap<String, String> tree = new TreeMap<>(new MyComparator());
        tree.put("a", "a");
        tree.put("b", "b");
        tree.put("d", "d");
        tree.put("c", "c");
        assertThat(tree.containsKey(null)).isFalse();
    }
}
