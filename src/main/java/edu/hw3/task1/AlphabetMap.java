package edu.hw3.task1;

import java.util.HashMap;

public class AlphabetMap {

    public HashMap<Character, Character> alphabet = new HashMap<>();

    public AlphabetMap() {
        for (Character i = 'a', j = 'z'; i <= 'z' && j >= 'a'; i++, j--) {
            alphabet.put(i, j);
        }

        for (Character i = 'A', j = 'Z'; i <= 'Z' && j >= 'A'; i++, j--) {
            alphabet.put(i, j);
        }

    }

}
