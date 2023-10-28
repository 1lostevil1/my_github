package hw3.task7;

import java.util.TreeMap;

public class Task7 {
    private Task7() {
    }

    public static void main(String[] args) {
        TreeMap<String, String> tree = new TreeMap<>(new MyComparator());
        tree.put("a", "a");
        tree.put("b", "b");
        tree.put(null, "n");
        tree.put("c", "c");
    }
}
