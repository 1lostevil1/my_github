package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("uncommentedmain")

public class Task8 {

    final static int ONE = 1;
    final static int TWO = 2;
    final static int EIGHT = 8;
    private final static Logger LOGGER = LogManager.getLogger();

    private Task8() {
    }

    public static boolean checkLeft(int[][] a, int i, int j) {
        return (i - ONE >= 0 && j - TWO >= 0 && a[i - ONE][j - TWO] == ONE
            || i + ONE < EIGHT && j - TWO >= 0 && a[i + ONE][j - TWO] == ONE);
    }

    public static boolean checkRight(int[][] a, int i, int j) {
        return (i - ONE >= 0 && j + TWO < EIGHT && a[i - ONE][j + TWO] == ONE
            || i + ONE < EIGHT && j + TWO < EIGHT && a[i + ONE][j + TWO] == ONE);
    }

    public static boolean checkTop(int[][] a, int i, int j) {
        return (i + TWO < EIGHT && j + ONE < EIGHT && a[i + TWO][j + ONE] == ONE
            || i + TWO < EIGHT && j - ONE >= 0 && a[i + TWO][j - ONE] == ONE);
    }

    public static boolean checkBottom(int[][] a, int i, int j) {
        return (i - TWO >= 0 && j + ONE < EIGHT && a[i - TWO][j + ONE] == ONE
            || i - TWO >= 0 && j - ONE >= 0 && a[i - TWO][j - ONE] == ONE);
    }


    public static boolean knightBoardCapture(int[][] a) {
        boolean res = true;
        for (int i = 0; i < EIGHT && res; i++) {
            for (int j = 0; j < EIGHT && res; j++) {
                if (a[i][j] == ONE) {
                    if (checkRight(a, i, j) || checkLeft(a, i, j) || checkBottom(a, i, j) || checkTop(a, i, j)) {
                        res = false;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] mas = {
            {0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 1, 0, 0, 0}
        };
        LOGGER.info("The horses are placed so that none of them can capture another horse is "
            + knightBoardCapture(mas));
    }

}

