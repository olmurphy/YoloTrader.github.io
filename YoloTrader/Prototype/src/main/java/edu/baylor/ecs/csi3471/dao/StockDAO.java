package edu.baylor.ecs.csi3471.dao;

import edu.baylor.ecs.csi3471.model.Stock;

import java.util.List;

public interface StockDAO {

    List<Stock> getStocks();

    void addStock(Stock stock);

    void removeStock(Stock stock);
}
