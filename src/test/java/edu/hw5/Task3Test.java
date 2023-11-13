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
        Optional<LocalDate> actual = Task3.parseDate("yesterday");
        Optional<LocalDate> expected = Optional.of(LocalDate.now().minusDays(1));
        assertEquals(expected, actual);

        actual = Task3.parseDate("today");
        expected = Optional.of(LocalDate.now());
        assertEquals(expected, actual);

        actual = Task3.parseDate("tomorrow");
        expected = Optional.of(LocalDate.now().plusDays(1));
        assertEquals(expected, actual);

        actual = Task3.parseDate("2020-10-10");
        expected = Optional.of(LocalDate.of(2020,10,10));
        assertEquals(expected, actual);

        actual = Task3.parseDate("2020-10-2");
        expected = Optional.of(LocalDate.of(2020,10,2));
        assertEquals(expected, actual);

        actual = Task3.parseDate("1/3/1976");
        expected = Optional.of(LocalDate.of(1976,3,1));
        assertEquals(expected, actual);

        actual = Task3.parseDate("1/3/20");
        expected = Optional.of(LocalDate.of(2020,3,1));
        assertEquals(expected, actual);

    }

    @Test
    @DisplayName("Некорректная строка")
    void invalidInput() {
         Optional<LocalDate> actual = Task3.parseDate("yesterdayy");
        Optional<LocalDate> expected = Optional.empty();
        assertEquals(expected, actual);

    }
}
