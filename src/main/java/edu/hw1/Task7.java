package edu.hw1;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("uncommentedmain")

public class Task7 {

    private final static Logger LOGGER = LogManager.getLogger();

    private Task7() {

    }

    public static int rotateLeft(int n, int shift) {

        int res = -1;

        if (n >= 0) {
            if (shift < 0) {
                res = rotateRight(n, -shift);
            } else {
                String tmp = Integer.toBinaryString(n);
                for (int i = 0; i < shift; i++) {
                    tmp = tmp.substring(1, tmp.length()) + tmp.charAt(0);
                }
                res = Integer.parseInt(tmp, 2);
            }
        }
        return res;
    }

    public static int rotateRight(int n, int shift) {

        int res = -1;

        if (n >= 0) {
            if (shift < 0) {
                res = rotateLeft(n, -shift);
            } else {
                String tmp = Integer.toBinaryString(n);
                for (int i = 0; i < shift; i++) {
                    tmp = tmp.charAt(tmp.length() - 1) + tmp.substring(0, tmp.length() - 1);
                }
                res = Integer.parseInt(tmp, 2);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int n;
        int shift;
        Scanner in = new Scanner(System.in);
        LOGGER.info("Input positive integer value.");
        n = in.nextInt();
        shift = in.nextInt();
        LOGGER.info("left shift result -> " + rotateLeft(n, shift));
        LOGGER.info("right shift result -> " + rotateRight(n, shift));
        in.close();
    }

}
