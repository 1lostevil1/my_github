package edu.project2;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InitTest {

    @Test
    @RepeatedTest(2000)
    public void someRepeatableTest() {
        Generate a = new Generate(11);
        boolean expected = true;
        boolean actual = a.gen3000();
        assertEquals(expected, actual);

    }

    @Test
    public void ExceptionTest() {
        Generate a = new Generate(11);
        a.gen3000();
        Cell start = new Cell(0, 0, false, true, true, false);
        Cell finish = new Cell(9, 9, false, false, false, false);
        Exception exception =  assertThrows(Exception.class, () ->a.wayFound(start,finish));
        String expectedMessage = "!!CELL IS WALL!!";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));

    }

}
