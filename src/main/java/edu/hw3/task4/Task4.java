package edu.hw3.task4;

import org.apache.logging.log4j.LogManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@SuppressWarnings("uncommentedmain")

public class Task4 {



        public static HashMap<Integer, String> map = new HashMap<>();;
        public static List<Integer> list= new ArrayList<>();

        private static void  initRomanMap() {
            final Integer[] KEY = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
            final String[] VAL = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
            Collections.addAll(list, KEY);
            int val = KEY.length;
            for (int i = 0; i < val; i++) {
                map.put(list.get(i), VAL[i]);
            }
        }





    private static final int VAL = 3994;

    private Task4() {
    }

    public static String toRoman(int value) {
        initRomanMap();
        StringBuilder result = new StringBuilder();
        if (value == 0) {
            return "N";
        }
        int copy = value;
        int index = 0;
        while (copy > 0) {
            Integer checker = list.get(index);
            while (copy >= checker) {
                int integ = copy / checker;
                copy = copy % checker;
                for (int i = 0; i < integ; i++) {
                    result.append(map.get(checker));
                }
            }
            index++;
        }
        return result.toString();
    }

    private final static org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        String wtf = toRoman(VAL);
        LOGGER.info(wtf);
    }
}
