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

    public static LocalDate ClosestFriday13(List<LocalDate> Fridays, LocalDate date) {
        for (LocalDate tmp : Fridays) {
            if (tmp.isAfter(date)) {
                return tmp;
            }
        }
        return null;
    }

    public static void main(String[] args) {

        List<LocalDate> list = isFriday13(1925);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i).toString() + ", ");
        }

    }
}
