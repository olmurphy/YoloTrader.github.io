package edu.baylor.ecs.csi3471.service;

import edu.baylor.ecs.csi3471.model.Stock;
import edu.baylor.ecs.csi3471.model.StockWatchList;

/**
 * this class injects the service of ${@link edu.baylor.ecs.csi3471.presentation.presentationLogic.StockController}
 * class
 * @author owenmurphy
 */
public class StockService {

    /**
     * injected service from the stock controller. checks if the stock passed
     * in is a unique stock in the watch list wanted to add it in
     * if so, it adds the stock, else do nothing, returns true if added, false o.w.
     * @param stock          stock to be added to the watchlist
     * @param stockWatchList watchlist to have the stock added to
     * @return true if stock added, false o.w.
     */
    public boolean addStock(Stock stock, StockWatchList stockWatchList) {
        if (stockWatchList.getStockList().stream().filter(x -> x.equals(stock)).findFirst().orElse(null) != null) { return false; }

        stockWatchList.getStockList().add(stock); // else add stock
        return true;
    }

    /**
     * removes the stock given from the list provided
     * @param name name of the stock to be deleted
     * @param list watch list to delete stock from
     * @return true if stock was deleted, o.w. false
     */
    public boolean removeStock(String name, StockWatchList list) { return list.getStockList().removeIf(stock -> stock.getName().equals(name)); }

    /**
     * method find the occurence of the stock name and returns in using Java 8 streams
     * @param name name of stock to find
     * @param list list that contains the stock
     * @return instance of Stock
     */
    public Stock findStock(String name, StockWatchList list) {
        return list.getStockList().stream().filter(x -> x.getName().equals(name)).findFirst().orElse(null);
    }
}
