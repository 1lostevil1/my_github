package hw3.task1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task1 {

    private final static int COUNT_OF_LETTERS = 25;
    private final static Logger LOGGER = LogManager.getLogger();

    public Task1() {
    }

    public static String atbash(String object) {
        alphabetList list = new alphabetList();
        char[] tmp = object.toCharArray();
        int len = object.length();
        for (int i = 0; i < len; i++) {
            int index = COUNT_OF_LETTERS - list.alphabet.indexOf(Character.toUpperCase(tmp[i]));
            System.out.print(tmp[i]);
            if (Character.isLowerCase(tmp[i])) {
                tmp[i] = Character.toLowerCase(list.alphabet.get(index));
            } else {
                tmp[i] = list.alphabet.get(index);
            }
        }
        object = String.copyValueOf(tmp);
        return object;
    }

    public static void main(String[] args) {
        LOGGER.info(atbash("Hello"));
    }

}
