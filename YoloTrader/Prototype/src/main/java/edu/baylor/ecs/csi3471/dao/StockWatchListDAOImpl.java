package edu.baylor.ecs.csi3471.dao;

import edu.baylor.ecs.csi3471.model.StockWatchList;

import java.util.List;

public class StockWatchListDAOImpl implements StockWatchListDAO {

    private List<StockWatchList> stockWatchLists;

    @Override
    public List<StockWatchList> getAllWatchLists() {
        return this.stockWatchLists;
    }

    @Override
    public void addWatchList(StockWatchList list) {
        this.stockWatchLists.add(list);
    }

    @Override
    public void setWatchList(List<StockWatchList> list) {
        this.stockWatchLists = list;
    }
}
