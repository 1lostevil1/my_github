package edu.hw1;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("uncommentedmain")

public class Task5 {

    private Task5() {
    }

    static boolean isPalindrome(String word) {
        boolean flag=true;
        int len= word.length();
        for (int i = 0; i < ( len/ 2); i++) {
            if (word.charAt(i) != word.charAt(len - i - 1)) {
                return false;
            }
        }
        return flag;
    }

    public static boolean isPalindromeDescendant(Integer num) {
        boolean flag = true;
        if (!isPalindrome(num.toString())) {
            String str = String.valueOf(num);
            String descendant = str;
            if (str.length() < 2 || str.length() % 2 == 1) {
                flag = false;
            } else {
                flag = false;
                while (!flag && str.length() >= 2 && str.length() % 2 == 0) {
                    descendant = "";
                    for (int i = 0; i < str.length() - 1; i += 2) {
                        descendant = descendant + ((str.charAt(i) - '0')
                            + (str.charAt(i + 1) - '0'));
                    }
                    if (descendant.length() >= 2 && isPalindrome(descendant)) {
                        flag = true;
                    }
                    str = descendant;
                }
            }
        }
        return flag;
    }


    private final static Logger LOGGER = LogManager.getLogger();

    //main
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LOGGER.info("Input value: ");
        Integer value = in.nextInt();
        LOGGER.info(isPalindromeDescendant(value));
        in.close();
    }
}

