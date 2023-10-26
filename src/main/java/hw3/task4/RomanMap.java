package hw3.task4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class RomanMap {

    private final static Integer[] array = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private final static String[] array2 = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    public static HashMap<Integer, String> map;
    public static List<Integer> list;

    public RomanMap() {
        map = new HashMap<>();
        list = new ArrayList<>();
        Collections.addAll(list, array);
        int val = array.length;
        for (int i = 0; i < val; i++) {
            map.put(list.get(i), array2[i]);
        }
    }
}


