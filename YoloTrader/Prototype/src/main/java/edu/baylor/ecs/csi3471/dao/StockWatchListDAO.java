package edu.baylor.ecs.csi3471.dao;

import edu.baylor.ecs.csi3471.model.StockWatchList;

import java.util.List;

public interface StockWatchListDAO {



    List<StockWatchList> getAllWatchLists();

    void addWatchList(StockWatchList list);

    void setWatchList(List<StockWatchList> list);

    boolean removeWatchList(StockWatchList stockWatchList);
}
