package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

class Task3Test {
    @Test
    @DisplayName("Корректная строка")
    void validInput() {
        // Given
        Optional<LocalDate> expected = Optional.of(LocalDate.now().minusDays(1));
        // When
        Optional<LocalDate> actual = Task3.parseDate("yesterday");
        // Then
        assertEquals(expected, actual);
        // Given
        expected = Optional.of(LocalDate.now());
        // When
        actual = Task3.parseDate("today");
        // Then
        assertEquals(expected, actual);

        // Given
        expected = Optional.of(LocalDate.now().plusDays(1));
        // When
        actual = Task3.parseDate("tomorrow");
        // Then
        assertEquals(expected, actual);

        // Given
        expected = Optional.of(LocalDate.of(2020,10,10));
        // When
        actual = Task3.parseDate("2020-10-10");
        // Then
        assertEquals(expected, actual);

        // Given
        expected = Optional.of(LocalDate.of(2020,10,2));
        // When
        actual = Task3.parseDate("2020-10-2");
        // Then
        assertEquals(expected, actual);

        // Given
        expected = Optional.of(LocalDate.of(1976,3,1));
        // When
        actual = Task3.parseDate("1/3/1976");
        // Then
        assertEquals(expected, actual);

        // Given
        expected = Optional.of(LocalDate.of(2020,3,1));
        // When
        actual = Task3.parseDate("1/3/20");
        // Then
        assertEquals(expected, actual);

    }

    @Test
    @DisplayName("Некорректная строка")
    void invalidInput() {
        // Given
        Optional<LocalDate> expected = Optional.empty();
        // When
         Optional<LocalDate> actual = Task3.parseDate("yesterdayy");
        // Then
        assertEquals(expected, actual);

    }
}
