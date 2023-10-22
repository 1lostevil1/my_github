package edu.hw2;

import edu.hw2.task3.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task3Test {
    @DisplayName("Проверка нескольких команд")
    @ParameterizedTest()
    @CsvSource({
        "apt download  && apt execute && apt delete ",
        "apt execute "
    })
    void check(String command) {
        boolean actual = false;
        boolean expected = true;
        try {
            PopularCommandExecutor exe = new PopularCommandExecutor();
            try {
                exe.tryExecute(command);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            actual = true;
        } catch (RuntimeException exception) {
            expected = false;
        }
        assertEquals(expected, actual);
    }

    @DisplayName("Проверка на ошибки")
    @RepeatedTest(10)
    void checkUpdate() throws Exception {
        boolean actual = false;
        boolean expected = true;
        try {
            PopularCommandExecutor exe = new PopularCommandExecutor();
            exe.updatePackages();
            actual = true;
        } catch (RuntimeException exception) {
            expected = false;
        }
        assertEquals(expected, actual);
    }
}
