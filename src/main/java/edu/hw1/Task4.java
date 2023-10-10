package edu.hw1;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task4 {

    private Task4() {

    }

    private final static int DEL = 2;

    public static boolean check(String str) {
        boolean flag = true;
        int len = str.length();
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == ' ') {
                flag = false;
            }
        }
        return flag;
    }

    public static String fixString(String str) {
        String copy = new String();
        if (check(str)) {
            int len = str.length();
            for (int i = 0; i < len - 1; i += 2) {
                copy += str.substring(i + 1, i + 2);
                copy += str.substring(i, i + 1);
            }
            if (len % DEL != 0) {
                copy += str.substring(len - 1, len);
            }
        } else {
            copy = "This is a mixed up string.";
        }
        return copy;
    }

    private final static Logger LOGGER = LogManager.getLogger();

    //main
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LOGGER.info("Input str: ");
        String str = in.nextLine();
        LOGGER.info(fixString(str));
        in.close();
    }
}
