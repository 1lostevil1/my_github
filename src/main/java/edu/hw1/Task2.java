package edu.hw1;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("uncommentedmain")

public class Task2 {
    private final static int DEL = 10;

    private Task2() {
    }

    public static int countDigits(int value) {
        Integer copy = value;
        int count = 0;
        if (copy.equals(0)) {
            count++;
        }
        while (copy != 0) {
            count++;
            copy /= DEL;
        }
        return count;
    }

    private final static Logger LOGGER = LogManager.getLogger();

    //main
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LOGGER.info("Input value: ");
        int val = in.nextInt();
        LOGGER.info(countDigits(val));
        in.close();
    }
}
