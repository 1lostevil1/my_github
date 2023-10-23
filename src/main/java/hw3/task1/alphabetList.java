package hw3.task1;

import java.util.ArrayList;
import java.util.Collections;

public class alphabetList {

    private Character[] arr = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
        'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    public ArrayList<Character> alphabet = new ArrayList<>();
    public alphabetList(){
        Collections.addAll(alphabet,arr);
    }



}
