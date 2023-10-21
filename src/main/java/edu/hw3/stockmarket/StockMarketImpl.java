package edu.hw3.stockmarket;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class StockMarketImpl implements StockMarket {
    private final Queue<Stock> stocks = new PriorityQueue<>(Collections.reverseOrder());

    @Override
    public void add(Stock stock) {
        stocks.add(stock);
    }

    @Override
    public void remove(Stock stock) {
        stocks.remove(stock);
    }

    @Override
    public Stock mostValuableStock() { // да, опять же не глагол. Но я реализую интерфейс из задания!
        return stocks.peek();
    }
}
