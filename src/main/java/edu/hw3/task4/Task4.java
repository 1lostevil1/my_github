package edu.hw3.task4;

import org.apache.logging.log4j.LogManager;

@SuppressWarnings("uncommentedmain")

public class Task4 {

    private static final int TEN = 10;

    private Task4() {
    }

    public static String toRoman(int value) {

        RomanMap romanian = new RomanMap();
        StringBuilder result = new StringBuilder();
        if (value == 0) {
            return "N";
        }
        Integer copy = value;
        int index = 0;
        while (copy > 0) {
            Integer checker = RomanMap.list.get(index);
            while (copy >= checker) {
                Integer integ = copy / checker;
                copy = copy % checker;
                for (int i = 0; i < integ; i++) {
                    result.append(RomanMap.map.get(checker));
                }
            }
            index++;
        }
        return result.toString();
    }

    private final static org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        int val = 3994;
        String wtf = toRoman(val);
        LOGGER.info(wtf);
    }
}
