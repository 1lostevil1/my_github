package edu.hw3.task4;

import org.apache.logging.log4j.LogManager;

@SuppressWarnings("uncommentedmain")

public class Task4 {

    private static final int VAL = 3994;

    private Task4() {
    }

    public static String toRoman(int value) {

        StringBuilder result = new StringBuilder();
        if (value == 0) {
            return "N";
        }
        int copy = value;
        int index = 0;
        while (copy > 0) {
            Integer checker = RomanMap.list.get(index);
            while (copy >= checker) {
                int integ = copy / checker;
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
        String wtf = toRoman(VAL);
        LOGGER.info(wtf);
    }
}
