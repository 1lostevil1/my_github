package edu.hw7.Task1;

import java.util.concurrent.atomic.AtomicInteger;

public class RaceCondition {
    private final static int MAX = 100;
    private static AtomicInteger value = new AtomicInteger(0);

    public static int Increment () {
        Thread firstThread = new Thread(() -> {
            for (int i = 0; i < MAX; i++) {
                value.incrementAndGet();
            }
        });
        Thread secondThread = new Thread(() -> {
            for (int i = 0; i < MAX; i++) {
                value.incrementAndGet();
            }
        });

        firstThread.start();
        secondThread.start();
        try {
            firstThread.join();
            secondThread.join();

        } catch (
            InterruptedException e) {
            e.printStackTrace();
        }
        return value.get();

    }
}
