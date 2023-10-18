package edu.hw1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("uncommentedmain")

public class Task6 {

    private final static int FOUR = 4;
    private final static int TEN = 10;
    private final static int CONSTKAPR = 6174;

    private final static Logger LOGGER = LogManager.getLogger();

    private Task6() {
    }

    public static int arrayToNum(Integer[] mas) {
        int num = 0;
        for (int i = 0; i < FOUR; i++) {
            num = num * TEN + mas[i];
        }
        return num;
    }

    public static Integer[] numToArray(int value) {
        Integer[] a = new Integer[FOUR];
        int value1 = value;
        for (int i = 0; i < FOUR; i++) {
            a[i] = value1 % TEN;
            value1 /= TEN;
        }
        return a;
    }

    public static int kapr(int val) {
        Integer[] a = numToArray(val);
        Integer[] amin = Arrays.copyOf(a, FOUR);
        Integer[] amax = Arrays.copyOf(a, FOUR);
        Arrays.sort(amin);
        Arrays.sort(amax, Comparator.reverseOrder());
        return arrayToNum(amax) - arrayToNum(amin);

    }

    public static int countK(int val) {

        int res = -1;
        if (val != CONSTKAPR) {
            res = 0;
            int val1 = kapr(val);
            if (val1 != CONSTKAPR) {
                res = countK(val1);
            }
        }
        return res + 1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LOGGER.info("Input value: ");
        int val = in.nextInt();
        LOGGER.info("count of steps to get a 6174 value " + countK(val));
        in.close();
    }

}



