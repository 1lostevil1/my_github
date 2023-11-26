package edu.hw7.Task1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RaceConditionTest {

    @Test
    @DisplayName("проверка на состояние гонки")
    void checkRace() {
        assertEquals(200,  RaceCondition.Increment());
    }

}
