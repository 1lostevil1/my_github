package hw3.task6;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("uncommentedmain")

public class Task6 {

    private Task6() {
    }

    private final static Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {

        int price = 5000;

        StockMarket market = new StockMarket();

        for (int i = 0; i < 5; i++) {
            market.add(new Stock(i * price));
        }
        LOGGER.info(market.mostValuableStock().get());

    }
}
