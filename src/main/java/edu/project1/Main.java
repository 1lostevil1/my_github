package edu.project1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
public final class Main {
    private final static Logger LOGGER = LogManager.getLogger();

    private Main() {
    }

    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        LOGGER.info("Hello and welcome!");

        for (int i = 0; i <= 2; i++) {


            // for you, but you can always add more by pressing Ctrl+F8.
            LOGGER.info("i = {}", i);
        }
    }
}
