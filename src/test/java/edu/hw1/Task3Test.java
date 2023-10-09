package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task3Test {
    @Test
    void isNested() {
        int[] mas1 = new int[] {1, 2, 3, 4};
        int[] mas2 = new int[] {0, 6};

        boolean actual = Task3.isNested(mas1, mas2);
        boolean expected = true;
        assertEquals(actual, expected);
        mas1 = new int[] {9, 9, 8};
        mas2 = new int[] {8, 9};
        actual = Task3.isNested(mas1, mas2);
        expected = false;
        assertEquals(actual, expected);

        mas1 = new int[] {0, 0, 0};
        mas2 = new int[] {0};
        actual = Task3.isNested(mas1, mas2);
        expected = false;
        assertEquals(actual, expected);

        mas1 = new int[] {-10, 1, 4};
        mas2 = new int[] {-11, 12};
        actual = Task3.isNested(mas1, mas2);
        expected = true;
        assertEquals(actual, expected);

        mas1 = new int[] {1,2,3,4};
        mas2 = new int[] {2,3};
        actual = Task3.isNested(mas1, mas2);
        expected = false;
        assertEquals(actual, expected);

    }

}
