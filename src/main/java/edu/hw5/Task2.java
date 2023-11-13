package edu.hw5;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Task2 {

    private Task2() {
    }

    public static List<LocalDate> isFriday13(Integer year) {
        if (year == null) {
            throw new IllegalArgumentException();
        }
        List<LocalDate> result = new ArrayList<>();
        LocalDate date = LocalDate.parse(year.toString() + "-01-13");
        while (date.getYear() == year) {
            if (date.getDayOfWeek().toString().equals("FRIDAY")) {
                result.add(date);
            }
            date = date.plusMonths(1);
        }
        return result;
    }

    public static LocalDate closestFriday13(List<LocalDate> fridays, LocalDate date) {
        for (LocalDate tmp : fridays) {
            if (tmp.isAfter(date)) {
                return tmp;
            }
        }
        return null;
    }

}
