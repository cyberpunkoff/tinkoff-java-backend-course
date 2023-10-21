package edu.hw3.stockmarket;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.assertj.core.api.Assertions.assertThat;

public class StockMarketTest {
    // TODO: check proper way of naming test methods?
    @Test
    void testMostValuableStock() {
        // given
        StockMarket stockMarket = new StockMarketImpl();
        stockMarket.add(new Stock("Google", new BigDecimal(1000)));
        stockMarket.add(new Stock("Amazon", new BigDecimal(2000)));
        stockMarket.add(new Stock("Tinkoff", new BigDecimal(3000)));

        // when
        Stock stock = stockMarket.mostValuableStock();

        // then
        assertThat(stock).isEqualTo(new Stock("Tinkoff", new BigDecimal(3000)));
    }

    @Test
    void testRemoveStock() {
        StockMarket stockMarket = new StockMarketImpl();
        Stock googleStock = new Stock("Google", new BigDecimal(1000));
        Stock yandexStock = new Stock("Yandex", new BigDecimal(500));
        stockMarket.add(yandexStock);
        stockMarket.add(googleStock);

        stockMarket.remove(googleStock);
        Stock stock = stockMarket.mostValuableStock();

        assertThat(stock).isEqualTo(yandexStock);
    }
}
