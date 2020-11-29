package edu.baylor.ecs.csi3471.dao;

import edu.baylor.ecs.csi3471.model.StockWatchList;

import java.util.ArrayList;
import java.util.List;

/**
 * @author owenmurphy
 */
public class StockWatchListDAO implements GenericDAO<StockWatchList> {

    private List<StockWatchList> stockWatchLists;

    public StockWatchListDAO() { this.stockWatchLists = new ArrayList<>(); }

    @Override
    public List<StockWatchList> getAll() { return this.stockWatchLists; }

    @Override
    public void setAll(List<StockWatchList> t) { this.stockWatchLists = t; }

    @Override
    public void delete(StockWatchList stockWatchList) { this.stockWatchLists.remove(stockWatchList); }

    @Override
    public void add(StockWatchList stockWatchList) { this.stockWatchLists.add(stockWatchList); }

    @Override
    public void update(int index, StockWatchList stockWatchList) { }
}
