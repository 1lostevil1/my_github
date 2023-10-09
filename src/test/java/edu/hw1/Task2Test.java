package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task2Test {
    @Test
    void countof(){
        Integer actual=Task2.countof(1234);
        Integer expected=4;
        assertEquals(actual, expected);

        actual=Task2.countof(0);
        expected=1;
        assertEquals(actual, expected);

        actual=Task2.countof(-1);
        expected=1;
        assertEquals(actual, expected);

        actual=Task2.countof(-500);
        expected=3;
        assertEquals(actual, expected);



    }

}
