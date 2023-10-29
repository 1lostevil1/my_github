package edu.hw3.task1;

import java.util.HashMap;

public abstract class AlphabetMap {

    public static HashMap<Character, Character> alphabet = new HashMap<>();

    public AlphabetMap() {
        for (char i = 'a', j = 'z'; i <= 'z'; i++, j--) {
            alphabet.put(i, j);
        }

        for (char i = 'A', j = 'Z'; i <= 'Z'; i++, j--) {
            alphabet.put(i, j);
        }

    }

}
