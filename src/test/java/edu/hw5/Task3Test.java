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
        // given
        Optional<LocalDate> expected = Optional.of(LocalDate.now().minusDays(1));
        // when
        Optional<LocalDate> actual = Task3.parseDate("yesterday");
        // then
        assertEquals(expected, actual);
        // given
        expected = Optional.of(LocalDate.now());
        // when
        actual = Task3.parseDate("today");
        // then
        assertEquals(expected, actual);

        // given
        expected = Optional.of(LocalDate.now().plusDays(1));
        // when
        actual = Task3.parseDate("tomorrow");
        // then
        assertEquals(expected, actual);

        // given
        expected = Optional.of(LocalDate.of(2020,10,10));
        // when
        actual = Task3.parseDate("2020-10-10");
        // then
        assertEquals(expected, actual);

        // given
        expected = Optional.of(LocalDate.of(2020,10,2));
        // when
        actual = Task3.parseDate("2020-10-2");
        // then
        assertEquals(expected, actual);

        // given
        expected = Optional.of(LocalDate.of(1976,3,1));
        // when
        actual = Task3.parseDate("1/3/1976");
        // then
        assertEquals(expected, actual);

        // given
        expected = Optional.of(LocalDate.of(2020,3,1));
        // when
        actual = Task3.parseDate("1/3/20");
        // then
        assertEquals(expected, actual);

    }

    @Test
    @DisplayName("Некорректная строка")
    void invalidInput() {
        // given
        Optional<LocalDate> expected = Optional.empty();
        // when
         Optional<LocalDate> actual = Task3.parseDate("yesterdayy");
        // then
        assertEquals(expected, actual);

    }
}
