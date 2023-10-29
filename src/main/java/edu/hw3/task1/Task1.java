package edu.hw3.task1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("uncommentedmain")

public class Task1 {

    private final static Logger LOGGER = LogManager.getLogger();

    public Task1() {
    }

    public static String atbash(String o) {
        AlphabetMap alphabet = new AlphabetMap();
        char[] tmp = o.toCharArray();
        int len = o.length();
        for (int i = 0; i < len; i++) {
            if ((tmp[i] >= 'a' && tmp[i] <= 'z') || (tmp[i] >= 'A' && tmp[i] <= 'Z')) {
                tmp[i] = alphabet.alphabet.get(tmp[i]);
            }
        }
        o = String.copyValueOf(tmp);
        return o;
    }

    public static void main(String[] args) {
        LOGGER.info(atbash(
            "Any fool can write code that a computer can understand"));
    }

}
