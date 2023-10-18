package edu.hw1;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("uncommentedmain")

public class Task3 {

    private Task3() {
    }

    public static int min(int[] mas) {
        int min = mas[0];
        int len = mas.length;
        for (int i = 1; i < len; i++) {
            min = Math.min(min, mas[i]);
        }
        return min;
    }

    public static int max(int[] mas) {
        int max = mas[0];
        int len = mas.length;
        for (int i = 1; i < len; i++) {
            max = Math.max(max, mas[i]);
        }
        return max;
    }

    public static boolean isNested(int[] mas1, int[] mas2) {
        return (mas1.length * mas2.length > 0) ? (min(mas1) > min(mas2) && max(mas1) < max(mas2)) : false;
    }

    private final static Logger LOGGER = LogManager.getLogger();

    //main
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LOGGER.info("Input mas1 length: ");
        int len1 = in.nextInt();
        int[] mas1 = new int[len1];
        for (int i = 0; i < len1; ++i) {
            mas1[i] = in.nextInt();
        }
        LOGGER.info("Input mas2 length: ");
        int len2 = in.nextInt();
        int[] mas2 = new int[len2];
        for (int i = 0; i < len2; ++i) {
            mas2[i] = in.nextInt();
        }
        LOGGER.info("value length is " + isNested(mas1, mas2));
        in.close();
    }
}

