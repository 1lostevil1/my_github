package edu.hw9.Task1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class Collector {

    private final static Logger LOGGER = LogManager.getLogger();

    private final BlockingQueue<Metric> collector;

    public Collector(int collectorSize) {
        collector = new LinkedBlockingDeque<>(collectorSize);
    }

    public void push(String metricName, double[] data) {
        try {
            collector.put(new Metric(metricName, data));
        } catch (InterruptedException e) {
            LOGGER.warn(e);
        }
    }

    public String collect() throws InterruptedException {
        Metric metric = null;
        try {
            metric = collector.take();
        } catch (InterruptedException e) {
            LOGGER.warn(e);
        }
        return metric.getName() + ": " + metric.sum() + " " + metric.avg() + " " + metric.max() + " " + metric.min();
    }
}
