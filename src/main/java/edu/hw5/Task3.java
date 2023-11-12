package edu.hw5;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task3 {

    private Task3(){
    }

        private final static Pattern DATE_PATTERN = Pattern.compile("^((\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2]\\d|3[0-1]))|" +
            "((\\d{4}-(0[1-9]|1[0-2])-([1-9]|[1-2]\\d|3[0-1])))|" +
            "(([1-9]|[1-2]\\d|3[0-1])/([1-9]|1[0-2])/\\d{4})|" +
            "(([1-9]|[1-2]\\d|3[0-1])/([1-9]|1[0-2])/\\d{2})|" +
            "(tomorrow)|" +
            "(today)|" +
            "(yesterday)|" +
            "(\\d+days?\sago))$");


    private static LocalDate Switcher(String string){
        LocalDate date;
        switch(string){
            case("tomorrow"): {
                date = LocalDate.now();
                date = date.plusDays(1);
                break;
            }
            case("today"): {
                date = LocalDate.now();
                break;
            }
            case("yesterday"): {
                date = LocalDate.now();
                date = date.minusDays(1);
                break;
            }
             default: {
                if(string.matches("(([1-9]|[1-2]\\d|3[0-1])/([1-9]|1[0-2])/\\d{2})|(([1-9]|[1-2]\\d|3[0-1])/([1-9]|1[0-2])/\\d{4})")){
                    String[] args = string.split("/");
                    date = LocalDate.of(Integer.parseInt(args[2]),Integer.parseInt(args[1]),Integer.parseInt(args[0]));
                }
                else{
                    int days = Integer.parseInt(string.substring(0, string.indexOf(" ")));
                    date = LocalDate.now();
                    date = date.minusDays(days);
                }
                break;
            }
        }
        return date;
    }
    Optional<LocalDate> parseDate(String string){
        LocalDate date = null;
        Matcher matcher = DATE_PATTERN.matcher(string);
        if(matcher.find()){
            try
            {
                date = LocalDate.parse(string);
            } catch(DateTimeParseException e){
                date = Switcher(string);
            }
        }
        return Optional.of(date);
    }
}
