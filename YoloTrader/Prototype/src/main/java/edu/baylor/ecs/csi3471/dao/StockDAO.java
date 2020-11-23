package edu.baylor.ecs.csi3471.dao;

import edu.baylor.ecs.csi3471.model.Stock;

import java.util.List;

/**
 * @author owenmurphy
 */
public class StockDAO implements GenericDAO<Stock> {

    private List<Stock> stocks;

    @Override
    public List<Stock> getAll() {
        return this.stocks;
    }

    @Override
    public void save(Stock stock) {
        // do nothing
    }

    @Override
    public void update(int index, Stock stock) {
        // do nothing
    }

    @Override
    public void delete(Stock stock) {
        this.stocks.remove(stock);
    }

    @Override
    public void add(Stock stock) {
        this.stocks.add(stock);
    }

    @Override
    public void setAll(List<Stock> t) {
        this.stocks = t;
    }

    @Override
    public void saveAll() {
        // do nothing
    }

    @Override
    public void loadAll() {
        // do nothing
    }
}
