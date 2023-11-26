package edu.project2;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InitTest {

    @RepeatedTest(2000)
    public void someRepeatableTest() {
        Generate a = new Generate(11);
        //given
        boolean expected = true;
        //when
        boolean actual = a.gen3000();
        //then
        assertEquals(expected, actual);

    }

    @Test
    public void ExceptionTest() {
        //given
        String expectedMessage = "!!CELL IS WALL!!";
        Cell start = new Cell(0, 0, false, true, true, false);
        Cell finish = new Cell(9, 9, false, false, false, false);
        //when
        Generate a = new Generate(11);
        a.gen3000();
        //then
        Exception exception =  assertThrows(Exception.class, () ->a.wayFound(start,finish));
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));

    }

}
