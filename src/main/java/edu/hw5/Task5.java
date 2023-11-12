package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task5 {

    private Task5() {
    }

    private final static Pattern CAR_NUMBER_PATTERN =
        Pattern.compile("^[АВЕКМНОРСТУХ]\\d{3}(?<!000)[АВЕКМНОРСТУХ]{2}\\d{2,3}$");

    public static boolean isCarNumber(String number) {
        if (number == null) {
            return false;
        }
        Matcher matcher = CAR_NUMBER_PATTERN.matcher(number);
        if (matcher.find()) {
            return true;
        }
        return false;
    }
}
