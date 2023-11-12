package edu.hw5;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Task2 {

    private Task2(){
    }

    public static List<String> isFriday13(Integer year){
        if(year == null) throw new IllegalArgumentException();
        List<String> result = new ArrayList<>();
        LocalDate date = LocalDate.parse(year.toString() + "-01-13");
        while (date.getYear() == year){
            if(date.getDayOfWeek().toString().equals("FRIDAY")){
                result.add(date.toString());
            }
            date = date.plusMonths(1);
        }
        return result;
    }

    public static void main(String[] args) {

        List<String> list = isFriday13(1925);
        for(int i = 0; i< list.size();i++){
            System.out.print(list.get(i) + ", ");
        }


    }
}
