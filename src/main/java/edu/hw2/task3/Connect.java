package edu.hw2.task3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Random;

public class Connect {

    private static final int MAX_ATTEMPTS = 3;

    final static String ERROR = "Error";

    final static String COMPLETE = " выполнена!";

    final static String CONNECTION = "Соединение для ";

    final static String CLOSE = " закрыто";

    private final static Logger LOGGER = LogManager.getLogger();



    public interface Connection extends AutoCloseable {
        void execute(String command);
    }

    public static class StableConnection implements Connection {
        public void execute(String command) {
            LOGGER.info(command + COMPLETE);
        }

        public void close() {
            LOGGER.info(CONNECTION + this.getClass().getSimpleName() + CLOSE);
        }
    }

    public static class FaultyConnection implements Connection {
        public final int intBOUND = 2;

        public void execute(String command) throws Task3.ConnectionException {
            Random random = new Random();

            if (random.nextInt(intBOUND) == 1) {
                throw new Task3.ConnectionException(ERROR, new RuntimeException());
            }
            LOGGER.info(command + COMPLETE);
        }

        public void close() {
            LOGGER.info(CONNECTION + this.getClass().getSimpleName() + CLOSE);
        }
    }

}
