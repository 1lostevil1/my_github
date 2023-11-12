package edu.hw5;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task3 {

    private Task3() {
    }

    private final static Pattern DATE_PATTERN = Pattern.compile("^((\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2]\\d|3[0-1]))|" +
        "((\\d{4}-(0[1-9]|1[0-2])-([1-9]|[1-2]\\d|3[0-1])))|" +
        "(([1-9]|[1-2]\\d|3[0-1])/([1-9]|1[0-2])/\\d{4})|" +
        "(([1-9]|[1-2]\\d|3[0-1])/([1-9]|1[0-2])/\\d{2})|" +
        "(tomorrow)|" +
        "(today)|" +
        "(yesterday)|" +
        "((\\d+)\sdays?\sago))$");

    private static LocalDate Switcher(String string) {
        LocalDate date = null;
        switch (string) {
            case ("tomorrow"): {
                date = LocalDate.now();
                date = date.plusDays(1);
                break;
            }
            case ("today"): {
                date = LocalDate.now();
                break;
            }
            case ("yesterday"): {
                date = LocalDate.now();
                date = date.minusDays(1);
                break;
            }
            default: {
                if (string.matches(
                    "(([1-9]|[1-2]\\d|3[0-1])/([1-9]|1[0-2])/\\d{2})|(([1-9]|[1-2]\\d|3[0-1])/([1-9]|1[0-2])/\\d{4})")) {
                    String[] args = string.split("/");
                    switch (args[2].length()) {
                        case 4: {
                            date = LocalDate.of(
                                Integer.parseInt(args[2]),
                                Integer.parseInt(args[1]),
                                Integer.parseInt(args[0])
                            );
                            break;
                        }

                        case 2: {
                            if (Integer.parseInt(args[2]) > 23) {
                                date = LocalDate.of(
                                    Integer.parseInt("19" + args[2]),
                                    Integer.parseInt(args[1]),
                                    Integer.parseInt(args[0])
                                );
                            } else {
                                date = LocalDate.of(
                                    Integer.parseInt("20" + args[2]),
                                    Integer.parseInt(args[1]),
                                    Integer.parseInt(args[0])
                                );
                            }
                            break;
                        }

                    }
                } else {
                    int days = Integer.parseInt(string.substring(0, string.indexOf(" ")));
                    date = LocalDate.now();
                    date = date.minusDays(days);
                }
                break;
            }
        }
        return date;
    }

    public static Optional<LocalDate> parseDate(String string) {
        LocalDate date;
        Matcher matcher = DATE_PATTERN.matcher(string);
        if (matcher.find()) {
            try {
                date = LocalDate.parse(string);
            } catch (DateTimeParseException e) {
                date = Switcher(string);
            }
        } else {
            return Optional.empty();
        }
        return Optional.of(date);
    }

    public static void main(String[] args) {

        Optional<LocalDate> a = parseDate("1/3/76");
        System.out.println(a);
    }
}
