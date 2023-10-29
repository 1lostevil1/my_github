package edu.hw3.task1;

import java.util.HashMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("uncommentedmain")

public class Task1 {

    private final static HashMap<Character, Character> ALPHABET = new HashMap<>();

    private static  void initAlphabetMap() {
        for (char i = 'a', j = 'z'; i <= 'z'; i++, j--) {
            ALPHABET.put(i, j);
        }

        for (char i = 'A', j = 'Z'; i <= 'Z'; i++, j--) {
            ALPHABET.put(i, j);
        }

    }

    private final static Logger LOGGER = LogManager.getLogger();

    private Task1() {
    }

    public static String atbash(String str) {
        initAlphabetMap();
        char[] tmp = str.toCharArray();
        int len = str.length();
        for (int i = 0; i < len; i++) {
            if ((tmp[i] >= 'a' && tmp[i] <= 'z') || (tmp[i] >= 'A' && tmp[i] <= 'Z')) {
                tmp[i] = ALPHABET.get(tmp[i]);
            }
        }
        return String.copyValueOf(tmp, 0, tmp.length);
    }

    public static void main(String[] args) {
        LOGGER.info(atbash(
            "Any fool can write code that a computer can understand"));
    }

}
