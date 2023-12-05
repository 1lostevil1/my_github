package edu.hw5;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Task2 {

    private Task2() {
    }

    public static List<LocalDate> collectFriday13(Integer year) {
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

    public static LocalDate closestFriday13(LocalDate date) {
        List<LocalDate> fridays = collectFriday13(date.getYear());
        for (LocalDate localdate : fridays) {
            if (localdate.isAfter(date)) {
                return localdate;
            }
        }

        return collectFriday13(date.getYear() + 1).get(0);
    }

}
