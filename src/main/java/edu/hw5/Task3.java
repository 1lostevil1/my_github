package edu.hw5;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("magicnumber")

public class Task3 {

    private Task3() {
    }

    private final static int TWENTYTHREE = 23;

    private final static Pattern DATE_PATTERN1 = Pattern.compile(
        "^(\\d{4}-(0[1-9]|1[0-2])-((0[1-9]|[1-9])|[1-2]\\d|3[0-1]))$");
    private final static Pattern DATE_PATTERN2 = Pattern.compile("^([1-9]|[1-2]\\d|3[0-1])/([1-9]|1[0-2])/\\d{4}$");
    private final static Pattern DATE_PATTERN3 = Pattern.compile("^(([1-9]|[1-2]\\d|3[0-1])/([1-9]|1[0-2])/\\d{2})$");
    private final static Pattern DATE_PATTERN4 = Pattern.compile("^(tomorrow)$");
    private final static Pattern DATE_PATTERN5 = Pattern.compile("^(today)$");
    private final static Pattern DATE_PATTERN6 = Pattern.compile("^(yesterday)$");
    private final static Pattern DATE_PATTERN7 = Pattern.compile("^((\\d+) days? ago)$");
    private final static List<Pattern> PATTERN_LIST = List.of(
        DATE_PATTERN1,
        DATE_PATTERN2,
        DATE_PATTERN3,
        DATE_PATTERN4,
        DATE_PATTERN5,
        DATE_PATTERN6,
        DATE_PATTERN7
    );

    private static LocalDate dateSwitcher(int patternIndex, String string) {
        LocalDate date = null;
        switch (patternIndex) {
            case (3): {
                date = LocalDate.now().plusDays(1);
                break;
            }
            case (4): {
                date = LocalDate.now();
                break;
            }
            case (5): {
                date = LocalDate.now().minusDays(1);
                break;
            }
            case (1): {
                String[] args = string.split("/");
                date = LocalDate.of(
                    Integer.parseInt(args[2]),
                    Integer.parseInt(args[1]),
                    Integer.parseInt(args[0])
                );
                break;
            }

            case (2): {
                String[] args = string.split("/");
                date = LocalDate.of(
                    Integer.parseInt((args[2].length() > TWENTYTHREE ? ("19" + args[2]) : ("20" + args[2]))),
                    Integer.parseInt(args[1]),
                    Integer.parseInt(args[0])
                );
                break;
            }

            case (6): {
                int days = Integer.parseInt(string.substring(0, string.indexOf(" ")));
                date = LocalDate.now().minusDays(days);
                break;
            }
            case (0): {
                String[] args = string.split("-");
                date = LocalDate.of(
                    Integer.parseInt(args[0]),
                    Integer.parseInt(args[1]),
                    Integer.parseInt(args[2])
                );
                break;
            }
            default: {
                break;
            }

        }
        return date;
    }

    public static Optional<LocalDate> parseDate(String string) {
        Matcher matcher;
        for (var pattern : PATTERN_LIST) {
            matcher = pattern.matcher(string);
            if (matcher.find()) {
                return Optional.of(dateSwitcher(PATTERN_LIST.indexOf(pattern), string));
            }
        }

        return Optional.empty();
    }

}
