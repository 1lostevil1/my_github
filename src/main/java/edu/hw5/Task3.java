package edu.hw5;

import java.time.LocalDate;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("uncommentedmain")

public class Task3 {

    private Task3() {
    }

    private final static int FOUR = 4;
    private final static int TWO = 2;
    private final static int TWENTYTHREE = 23;

    private final static Pattern DATE_PATTERN = Pattern.compile("^((\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2]\\d|3[0-1]))|"
        + "(\\d{4}-(0[1-9]|1[0-2])-([1-9]|[1-2]\\d|3[0-1]))|"
        + "(([1-9]|[1-2]\\d|3[0-1])/([1-9]|1[0-2])/\\d{4})|"
        + "(([1-9]|[1-2]\\d|3[0-1])/([1-9]|1[0-2])/\\d{2})|"
        + "(tomorrow)|"
        + "(today)|"
        + "(yesterday)|"
        + "((\\d+) days? ago))$");

    private static LocalDate dateSwitcher(String string) {
        LocalDate date = null;
        switch (string) {
            case ("tomorrow"): {
                date = LocalDate.now().plusDays(1);
                break;
            }
            case ("today"): {
                date = LocalDate.now();
                break;
            }
            case ("yesterday"): {
                date = LocalDate.now().minusDays(1);
                break;
            }
            default: {
                if (string.matches(
                    "(([1-9]|[1-2]\\d|3[0-1])/([1-9]|1[0-2])/\\d{2})|"
                        + "(([1-9]|[1-2]\\d|3[0-1])/([1-9]|1[0-2])/\\d{4})")) {
                    String[] args = string.split("/");
                    switch (args[2].length()) {
                        case FOUR: {
                            date = LocalDate.of(
                                Integer.parseInt(args[2]),
                                Integer.parseInt(args[1]),
                                Integer.parseInt(args[0])
                            );
                            break;
                        }

                        case TWO: {
                            if (Integer.parseInt(args[2]) > TWENTYTHREE) {
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
                        default: break;

                    }
                    break;

                } else if (string.matches("((\\d+) days? ago)")) {
                    int days = Integer.parseInt(string.substring(0, string.indexOf(" ")));
                    date = LocalDate.now().minusDays(days);
                    break;
                } else if (string.matches("(\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2]\\d|3[0-1]))|"
                    + "(\\d{4}-(0[1-9]|1[0-2])-([1-9]|[1-2]\\d|3[0-1]))")) {
                    String[] args = string.split("-");
                    date = LocalDate.of(
                        Integer.parseInt(args[0]),
                        Integer.parseInt(args[1]),
                        Integer.parseInt(args[2])
                    );
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
            date = dateSwitcher(string);
        } else {
            return Optional.empty();
        }
        return Optional.of(date);
    }

}
