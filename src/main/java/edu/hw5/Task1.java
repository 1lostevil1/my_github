package edu.hw5;

import java.text.ParseException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1 {

    private Task1(){
    }

    final static int SECOND_DATE = 5;
    final static int FIRST_DATE = 1;
    public static final Pattern DATA_PATTERN = Pattern.compile("^(\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2]\\d|3[0-1]),"
        + " ([0-1]\\d|2[0-4]):[0-5]\\d) - (\\d{4}-(0[1-9]|1[0-2])"
        + "-(0[1-9]|[1-2]\\d|3[0-1]), ([0-1]\\d|2[0-4]):[0-5]\\d)$");

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
                    String[] First = (matcher.group(FIRST_DATE)).split(", ");
                    String[] Second = (matcher.group(SECOND_DATE)).split(", ");
                    LocalDateTime FirstDateTime = LocalDateTime.of( LocalDate.parse(First[0]), LocalTime.parse(First[1]));
                    LocalDateTime SecondDateTime = LocalDateTime.of( LocalDate.parse(Second[0]), LocalTime.parse(Second[1]));
                    fullDuration += (int) Duration.between(FirstDateTime, SecondDateTime).getSeconds();
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



    public static  void main(String[] args){

    List<String> list = List.of(
        "2022-03-12, 20:20 - 2022-03-12, 23:50",
        "2022-04-01, 21:30 - 2022-04-02, 01:20"
    );

   Duration a = getDuration(list);
   System.out.println(a);
    }
}
