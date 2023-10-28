package hw3;

import org.apache.logging.log4j.LogManager;
import java.util.HashMap;
import java.util.List;
import java.util.Arrays;

public class Task3 {
    private Task3() {
    }

    public static HashMap<?, Integer> freqDict(List<?> list) {
        HashMap<Object, Integer> Map = new HashMap<>();
        for (int i = 0; i < list.size(); ++i) {
            if (Map.containsKey(list.get(i))) {
                Map.replace(list.get(i), Map.get(list.get(i)) + 1);
            } else {
                Map.put(list.get(i), 1);
            }
        }
        return Map;
    }

    private final static org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 1, 1, 1, 2);
        List<String> list2 = Arrays.asList("aa", "aa", "bb", "cc");
        HashMap< ?, Integer> map = freqDict(list2);
        LOGGER.info(map);
    }
}
