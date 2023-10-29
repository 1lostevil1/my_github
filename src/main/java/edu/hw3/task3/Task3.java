package edu.hw3.task3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.apache.logging.log4j.LogManager;

@SuppressWarnings("uncommentedmain")

public class Task3 {
    private Task3() {
    }

    public static HashMap<?, Integer> freqDict(List<?> list) {
        HashMap<Object, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); ++i) {
            if (map.containsKey(list.get(i))) {
                map.replace(list.get(i), map.get(list.get(i)) + 1);
            } else {
                map.put(list.get(i), 1);
            }
        }
        return map;
    }

    private final static org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 1, 1, 1, 2);
        List<String> list2 = Arrays.asList("aa", "aa", "bb", "cc");
        HashMap<?, Integer> map = freqDict(list2);
        LOGGER.info(map);
    }
}
