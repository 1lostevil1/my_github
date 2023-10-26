package hw3;

import org.apache.logging.log4j.LogManager;
import java.util.HashMap;
import java.util.List;
import java.util.Arrays;

public class Task3 {
    private Task3() {
    }

    public static HashMap<String, Integer> freqDict(List<?> list) {
        HashMap< String, Integer> map = new HashMap<>();
        String s;
        for (int i = 0; i < list.size(); i++) {
            s = "\"" + list.get(i).toString() + "\"";
            if (map.containsKey(s)) {
                map.replace(s, map.get(s), map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }
        return map;
    }

    private final static org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 1, 1, 1, 2);
        HashMap< String, Integer> map = freqDict(list);

        LOGGER.info(map);
    }
}
