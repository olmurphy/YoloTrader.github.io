package edu.baylor.ecs.csi3471.dao;

import edu.baylor.ecs.csi3471.model.Stock;

import java.util.List;

/**
 * @author owenmurphy
 */
public class StockDAOImpl implements StockDAO {

    private List<Stock> stocks;

    @Override
    public List<Stock> getStocks() {
        return this.stocks;
    }

    @Override
    public void addStock(Stock stock) {
        this.stocks.add(stock);
    }

    @Override
    public void removeStock(Stock stock) {
        this.stocks.remove(stock);
    }
}
