package edu.hw3.task4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;



public abstract class RomanMap {

    public static HashMap<Integer, String> map;
    public static List<Integer> list;

    public RomanMap() {
         final Integer[] KEY = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
         final String[] VAL = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        map = new HashMap<>();
        list = new ArrayList<>();
        Collections.addAll(list, KEY);
        int val = KEY.length;
        for (int i = 0; i < val; i++) {
            map.put(list.get(i), VAL[i]);
        }
    }
}


