package hw3.task6;

import java.util.PriorityQueue;

public class StockMarket implements StockMarketInterface {

    public PriorityQueue<Stock> queue;

    public StockMarket() {
        queue = new PriorityQueue<>();
    }

    public void add(Stock stock) {
        queue.offer(stock);
    }

    public void remove(Stock stock) {
        queue.remove(stock);
    }

    public Stock mostValuableStock() {
        return queue.peek();
    }
}
