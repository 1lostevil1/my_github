package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task1Test {
@Test
    void minutesToSeconds(){
    Integer actual=Task1.minutesToSeconds("1234");
    Integer expected=-1;
    assertEquals(actual, expected);

    actual=Task1.minutesToSeconds("1234:");
    assertEquals(actual, expected);

    actual=Task1.minutesToSeconds(":1234");
    assertEquals(actual, expected);

    actual=Task1.minutesToSeconds("ab:50");
    assertEquals(actual, expected);

    actual=Task1.minutesToSeconds("54:666");
    assertEquals(actual, expected);

    actual=Task1.minutesToSeconds("-544:56");
    assertEquals(actual, expected);

    actual=Task1.minutesToSeconds("50:-20");
    assertEquals(actual, expected);

    actual=Task1.minutesToSeconds("");
    assertEquals(actual, expected);

    actual=Task1.minutesToSeconds(":");
    assertEquals(actual, expected);

    actual=Task1.minutesToSeconds("12:00");
    expected=720;
    assertEquals(actual, expected);

    actual=Task1.minutesToSeconds("12:10");
    expected=730;
    assertEquals(actual, expected);
}

}
