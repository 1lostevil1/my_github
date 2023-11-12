package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task6 {

    private Task6(){
    }

    public static boolean isSubsequence(String subsequence, String str) {
        if(subsequence!= null && str!=null ) {
            if(subsequence.equals("")) return true;
            String[] subsequents = subsequence.split("");
            StringBuilder pattern = new StringBuilder();
            for (String i : subsequents) {
                pattern.append(i);
                pattern.append("\\w*");
            }
            Pattern subsequencePatter = Pattern.compile(pattern.toString());
            Matcher matcher = subsequencePatter.matcher(str);
            if (matcher.find()) {
                return true;
            }
        }
        return false;
    }
}
