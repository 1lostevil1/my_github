package hw3.task6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task6Test {
    @Test
    @DisplayName("Добавление акции без указания её стоимости")
    void inputTest() {
        Stock stock = new Stock();
        StockMarket myMarket = new StockMarket();
        myMarket.add(stock);
        var actual = myMarket.mostValuableStock();
        assertEquals(stock, actual);
    }

    @Test
    @DisplayName("basic test")
    void basicTest() {

        StockMarket market = new StockMarket();
        Stock stock1 = new Stock(10000);
        Stock stock2 = new Stock(5);
        Stock stock3 = new Stock(123);
        Stock stock4 = new Stock(46000);
        Stock stock5 = new Stock(2000);
        market.add(stock1);
        market.add(stock2);
        market.add(stock3);
        market.add(stock4);
        market.add(stock5);

        Stock actual = market.mostValuableStock();
        assertEquals(stock4, actual);

        market.remove(stock4);
        actual = market.mostValuableStock();
        assertEquals(stock1, actual);
    }
}
