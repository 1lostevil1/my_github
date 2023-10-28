package hw3.task6;

import hw3.task6.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task6 {

    private Task6() {
    }

    private final static Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {

        StockMarket market = new StockMarket();
        market.add(new Stock(10000));
        market.add(new Stock(2000));
        market.add(new Stock(3000));
        market.add(new Stock(46000));
        market.add(new Stock(5000));
        LOGGER.info(market.mostValuableStock().get());

    }
}
