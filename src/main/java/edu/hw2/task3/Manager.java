package edu.hw2.task3;

import java.util.Random;

@SuppressWarnings("uncommentedmain")

public class Manager {

    public interface ConnectionManager {
        Connect.Connection getConnection();
    }

    public static class DefaultConnectionManager implements ConnectionManager {
        public final int intBOUND = 5;

        public Connect.Connection getConnection() {
            Random random = new Random();
            if (random.nextInt(intBOUND) == 0) {
                return new Connect.FaultyConnection();
            } else {
                return new Connect.StableConnection();
            }
        }
    }

    public static class FaultyConnectionManager implements ConnectionManager {
        public Connect.Connection getConnection() {
            return new Connect.FaultyConnection();
        }
    }
}
