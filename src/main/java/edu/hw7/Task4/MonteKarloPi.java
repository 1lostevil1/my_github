package edu.hw7.Task4;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.LongAdder;

@SuppressWarnings({"UncommentedMain", "RegexpSinglelineJava", "MagicNumber"})
public class MonteKarloPi {

    private final static int RADIUS = 4;

    private MonteKarloPi() {
    }

    // Cреднее время ускорения решения.
    // 2 потока.
    // Показатель ускорения колебался от 4.7 до 5.66,
    // максимальный показатель был при количестве точек: 1_000_000_000

    // Уровень погрешности для симуляции:
    // в 10млн симуляций  - 0.0006817
    // в 100млн симуляций - 0.0000484
    // в 1млрд симуляций  - 0.00000658

    public static double PiCalculate(long iterCount) {

        double circleCount = 0;
        for (long i = 0; i < iterCount; i++) {
            point point = new point(new Random().nextFloat(-RADIUS, RADIUS), new Random().nextFloat(-RADIUS, RADIUS));
            if (point.x() * point.x() + point.y() * point.y() <= RADIUS * RADIUS) {
                circleCount++;
            }
        }
        return 4 * (circleCount / iterCount);
    }

    public static double ParallelPiCalculate(long iterCount) {

        LongAdder circleCount = new LongAdder();
        int numberOfThread = 2;
        Runnable lambda = (() -> {
            for (int i = 1; i <= iterCount / numberOfThread; ++i) {
                point point =
                    new point(
                        ThreadLocalRandom.current().nextFloat(-RADIUS, RADIUS),
                        ThreadLocalRandom.current().nextFloat(-RADIUS, RADIUS)
                    );
                if (point.x() * point.x() + point.y() * point.y() <= RADIUS * RADIUS) {
                    circleCount.increment();
                }
            }
        });
        var thread1 = new Thread(lambda);
        var thread2 = new Thread(lambda);
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return (4.0 * circleCount.longValue()) / iterCount;
    }

    public static void main(String[] args) {
        long before = System.nanoTime();
        double result1 = PiCalculate(10000);
        long after = System.nanoTime();
        long nanoSecFirst = after - before;

        before = after;
        double result2 = ParallelPiCalculate(1000000000);
        after = System.nanoTime();
        long nanoSecSecond = after - before;
        System.out.println(Math.abs((float) result2 - Math.PI));
        System.out.println((double) nanoSecFirst / nanoSecSecond);

    }
}
