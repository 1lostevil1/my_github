package hw3.task1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task1 {

    private final static Logger LOGGER = LogManager.getLogger();

    public Task1() {
    }

    public static String atbash(String object) {
        alphabetMap alphabet = new alphabetMap();
        char[] tmp = object.toCharArray();
        int len = object.length();
        for (int i = 0; i < len; i++) {
            if ((tmp[i] >= 'a' && tmp[i] <= 'z') || (tmp[i] >= 'A' && tmp[i] <= 'Z')) {
                tmp[i] = alphabet.alphabet.get(tmp[i]);
            }
        }
        object = String.copyValueOf(tmp);
        return object;
    }

    public static void main(String[] args) {
        LOGGER.info(atbash(
            "Any fool can write code that a computer can understand. Good programmers write code that humans can understand. ― Martin Fowler"));
    }

}
