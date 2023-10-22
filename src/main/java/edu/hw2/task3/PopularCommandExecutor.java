package edu.hw2.task3;

import java.util.Random;

public class PopularCommandExecutor {
    final static String ERROR = "Error";
    private Manager.ConnectionManager manager;
    private int maxAttempts = 2;

    public PopularCommandExecutor() {
        final int intBOUND = 2;
        Random random = new Random();
        manager = (random.nextInt(intBOUND) == 1) ? new Manager.DefaultConnectionManager()
            : new Manager.FaultyConnectionManager();
    }

    public void updatePackages() throws Exception {
        tryExecute("apt update && apt upgrade -y");
    }

    public void tryExecute(String command) throws Exception {
        final Connect.Connection connection = manager.getConnection();
        boolean fl = true;
        for (int cnt = 1; cnt <= maxAttempts && fl; cnt++) {
            try (connection) {
                connection.execute(command);
                fl = false;
            } catch (Task3.ConnectionException e) {
                fl = true;
                if (cnt == maxAttempts) {
                    throw new Task3.ConnectionException(ERROR, new RuntimeException());
                }
            }
        }
    }
}

