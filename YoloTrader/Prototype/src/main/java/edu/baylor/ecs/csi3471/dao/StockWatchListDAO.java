package edu.baylor.ecs.csi3471.dao;

import edu.baylor.ecs.csi3471.model.StockWatchList;

import java.util.ArrayList;
import java.util.List;

/**
 * Stock watch list dao handles the events of the list of watch lists
 * @author owenmurphy
 */
public class StockWatchListDAO implements GenericDAO<StockWatchList> {

    /** list of stock watch lists the dao accesses  */
    private List<StockWatchList> stockWatchLists;

    /** the constructor declares an instance of the only attribute in the class */
    public StockWatchListDAO() { this.stockWatchLists = new ArrayList<>(); }

    /**
     * @return the list of stock watch lists
     */
    @Override
    public List<StockWatchList> getAll() { return this.stockWatchLists; }

    /**
     * sets the list of stock was lists
     * @param t list of items
     */
    @Override
    public void setAll(List<StockWatchList> t) { this.stockWatchLists = t; }

    /**
     * deletes the stock watch list passed in from the list
     * @param t item to be deleted
     */
    @Override
    public void delete(StockWatchList t) { this.stockWatchLists.remove(t); }

    /**
     * adds the stock watch list item to the list
     * @param t item to be added
     */
    @Override
    public void add(StockWatchList t) { this.stockWatchLists.add(t); }

    /**
     * updates the stock watch list in the list of watch lists at the index provided
     * @param index index of item
     * @param t item to be updated
     */
    @Override
    public void update(int index, StockWatchList t) { this.stockWatchLists.set(index, t); }
}
