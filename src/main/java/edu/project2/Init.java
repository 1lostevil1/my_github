package edu.project2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("uncommentedmain")

public class Init {

    private Init() {
    }

    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        final int SIZE = 21;
        final int x1 = 1;
        final int y1 = 1;
        final int x2 = 9;
        final int y2 = 9;
        Generate a = new Generate(SIZE);
        a.gen3000();

        Cell start = new Cell(x1, y1, false, true, true, false);
        Cell finish = new Cell(x2, y2, false, false, false, false);
        try {
            a.wayFound(start, finish);
        } catch (Exception ex) {
            LOGGER.info(ex.getMessage());
        }
        a.print();
    }
}
