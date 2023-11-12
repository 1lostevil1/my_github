package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.Duration;
import java.util.List;
import static edu.hw5.Task1.getDuration;
import static org.junit.jupiter.api.Assertions.*;

class Task2Test {
    @Test
    @DisplayName("Корректный год")
    void validInput() {
        List<String> actual = Task2.isFriday13(1925);
        List<String> expected = List.of("1925-02-13", "1925-03-13", "1925-11-13");
        assertEquals(expected, actual);

        actual = Task2.isFriday13(2024);
         expected = List.of("2024-09-13", "2024-12-13");
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Некорректный ввод")
    void invalidInput() {
        assertThrows(IllegalArgumentException.class, () -> Task2.isFriday13(null));

    }
}
