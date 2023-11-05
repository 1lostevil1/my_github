package edu.project2;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InitTest {

    @Test
    @RepeatedTest(2000)
    public void someRepeatableTest() {
        Generate a = new Generate(11);
        a.maze();
        boolean expected = true;
        boolean actual = a.GEN3000();
        assertEquals(expected, actual);

    }

}
