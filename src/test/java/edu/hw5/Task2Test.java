package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class Task2Test {
    @Test
    @DisplayName("Корректный год")
    void validInput() {
        // Given
        List<LocalDate> expected =
            List.of(LocalDate.parse("1925-02-13"), LocalDate.parse("1925-03-13"), LocalDate.parse("1925-11-13"));
        // When
        List<LocalDate> actual = Task2.collectFriday13(1925);

        // Then
        assertEquals(expected, actual);

        // Given
        expected = List.of(LocalDate.parse("2024-09-13"), LocalDate.parse("2024-12-13"));
        // When
        actual = Task2.collectFriday13(2024);
        // Then
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Некорректный ввод")
    void invalidInput() {
        // Then
        assertThrows(IllegalArgumentException.class, () -> Task2.collectFriday13(null));

    }

    @Test
    @DisplayName("Проверка ближайшей пятницы13 если такая есть")
    void isValidClosest() {
        // Given
        LocalDate expected = LocalDate.parse("1925-11-13");
        // When
        LocalDate actual = Task2.closestFriday13(LocalDate.of(1925, 9, 10));
        // Then
        assertEquals(expected, actual);

        // Given
        expected = LocalDate.parse("1925-02-13");
        // When
        actual = Task2.closestFriday13(LocalDate.of(1924, 12, 30));
        // Then
        assertEquals(expected, actual);
    }

}
