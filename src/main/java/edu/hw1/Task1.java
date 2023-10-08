package edu.hw1;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("uncommentedmain")

public class Task1 {

    public static int minutesToSeconds(String str) {
        final int trans = 60;
        int result;
        if (check(str)) {
            int pos = str.indexOf(':');
            result = Integer.parseInt(str.substring(0, pos)) * trans + Integer.parseInt(str.substring(pos + 1));
        } else {
            result = -1;
        }
        return result;
    }

    private Task1() {
    }

    public static boolean check(String str) {
        final int trans = 60;
        boolean flag = true;
        int len = str.length();
        Integer pos = str.indexOf(':');
        if (pos.equals(-1) || pos.equals(len - 1)) {
            flag = false;
        }
        if (flag) {
            String checkmin = str.substring(0, str.indexOf(':'));
            String checksec = str.substring(str.indexOf(':') + 1, len);
            if (checkmin.length() < 2 || checksec.length() != 2 || Integer.parseInt(checksec) > trans) {
                flag = false;
            }
        }
        boolean flag2 = false;
        for (int i = 0; i < len && flag; ++i) {

            if (str.charAt(i) == ':' && !flag2) {
                flag2 = true;
            } else if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                flag = false;
            }

        }
        return (flag && flag2 && str.charAt(0) != ':');
    }

    private final static Logger LOGGER = LogManager.getLogger();

    //main
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LOGGER.info("Input time: ");
        String str = in.nextLine();
        LOGGER.info(minutesToSeconds(str));
        in.close();
    }
}
