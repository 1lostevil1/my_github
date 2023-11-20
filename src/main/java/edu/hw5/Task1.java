package edu.hw5;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1 {

    private final static int SECOND_DATE = 6;
    private final static int SECOND_TIME = 9;
    private final static int FIRST_DATE = 1;
    private final static int FIRST_TIME = 4;
    private static final Pattern DATA_PATTERN = Pattern.compile("^(\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2]\\d|3[0-1])),"
        + " (([0-1]\\d|2[0-4]):[0-5]\\d) - (\\d{4}-(0[1-9]|1[0-2])"
        + "-(0[1-9]|[1-2]\\d|3[0-1])), (([0-1]\\d|2[0-4]):[0-5]\\d)$");

    private Task1() {
    }

    public static Duration getDuration(List<String> baseTime) {
        int sessionCount = 0;
        int fullDuration = 0;
        if (baseTime.isEmpty()) {
            throw new RuntimeException("the passed values are empty");
        }
        for (String session : baseTime) {
            Matcher matcher = DATA_PATTERN.matcher(session);

            if (matcher.find()) {
                try {
                    LocalDateTime firstDateTime = LocalDateTime.of(
                        LocalDate.parse(matcher.group(FIRST_DATE)),
                        LocalTime.parse(matcher.group(FIRST_TIME))
                    );
                    LocalDateTime secondDateTime = LocalDateTime.of(
                        LocalDate.parse(matcher.group(SECOND_DATE)),
                        LocalTime.parse(matcher.group(SECOND_TIME))
                    );
                    fullDuration += (int) Duration.between(firstDateTime, secondDateTime).getSeconds();
                    ++sessionCount;
                } catch (DateTimeParseException e) {
                    throw new RuntimeException("Parse Exeption");
                }

            } else {
                throw new RuntimeException("Invalid data format");
            }
        }
        return Duration.ofSeconds((long) fullDuration / sessionCount);
    }

}
