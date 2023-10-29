package edu.hw3.task6;

import java.util.Random;

public class Stock implements Comparable<Stock> {

    private Integer price;
    private final static Integer maxprice = 5000;

    public Stock(Integer price) {
        this.price = price;
    }

    public Stock() {
        Random rnd = new Random();
        price = rnd.nextInt(maxprice) + 1;
    }

    public Integer get() {
        return price;
    }

    @Override
    public int compareTo(Stock stock) {
        return stock.price - this.price;
    }
}
