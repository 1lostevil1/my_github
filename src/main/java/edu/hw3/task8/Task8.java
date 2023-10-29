package edu.hw3.task8;

import java.util.List;
import org.apache.logging.log4j.LogManager;

@SuppressWarnings("uncommentedmain")

public class Task8 {
    private Task8() {
    }

    private final static org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {

        final int one = 1;
        final int two = 2;
        final int three = 3;
        BackwardIterator<Integer> it = new BackwardIterator<>(List.of(one, two, three));

        while (it.hasNext()) {

            LOGGER.info(it.next());
        }

    }
}
