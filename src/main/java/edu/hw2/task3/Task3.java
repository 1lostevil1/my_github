package edu.hw2.task3;

@SuppressWarnings("uncommentedmain")

public class Task3 {

    private Task3() {
    }

    public static void main(String[] args) throws Exception {
        PopularCommandExecutor executor;
        executor = new PopularCommandExecutor();
        executor.updatePackages();
    }

    public static class ConnectionException extends RuntimeException {
        public ConnectionException(String message, Throwable cause) {
            super(message, cause);
        }
    }

}
