package hw3.Task6;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("uncommentedmain")

public class Task6 {

    private Task6() {
    }

    private final static Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {

        StockMarket market = new StockMarket();
        for( int i = 0; i < 5; i++){
            market.add(new Stock(i*5000));
        }
        LOGGER.info(market.mostValuableStock().get());

    }
}
