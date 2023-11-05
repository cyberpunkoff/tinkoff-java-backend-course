package edu.hw3.stockmarket;

import java.math.BigDecimal;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

public class Stock implements Comparable<Stock> {
    private BigDecimal price;
    private String name;
//    private String ticker; <-- лень реализовывать

    Stock(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    @Override public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Stock stock = (Stock) o;
        return Objects.equals(price, stock.price) && Objects.equals(name, stock.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, name);
    }

    @Override public String toString() {
        return "Stock{" + "price=" + price + ", name='" + name + '\'' + '}';
    }

    @Override
    public int compareTo(@NotNull Stock o) {
        return price.compareTo(o.price);
    }
}
