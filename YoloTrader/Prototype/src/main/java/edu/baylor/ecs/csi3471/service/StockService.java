package edu.baylor.ecs.csi3471.service;

import edu.baylor.ecs.csi3471.model.Stock;
import edu.baylor.ecs.csi3471.model.StockWatchList;

import java.util.List;

/**
 * this class
 * @author owenmurphy
 */
public class StockService {

    /**
     * injected service from the stock controller. checks if the stock passed
     * in is a unique stock in the watch list wanted to add it in
     * if so, it adds the stock, else do nothing, returns true if added, false o.w.
     * @param stock stock to be added to the watchlist
     * @param stockWatchList watchlist to have the stock added to
     * @return true if stock added, false o.w.
     */
    public boolean addStock(Stock stock, StockWatchList stockWatchList) {
        List<Stock> stocks = stockWatchList.getStockList(); // get stock from the dao

        boolean isUnique = true;

        // check if the stock is unique
        for (Stock value : stocks) {
            if (value.equals(stock)) {
                isUnique = false;
                break;
            }
        }

        if (isUnique) {
            stocks.add(stock);
        }

        return isUnique;
    }

    /**
     * removes the stock given from the list provided
     * @param name name of the stock to be deleted
     * @param list watch list to delete stock from
     * @return true if stock was deleted, o.w. false
     */
    public boolean removeStock(String name, StockWatchList list) {
        boolean stockRemoved = false;
        List<Stock> stocks = list.getStockList();

        for (int i = 0; i < stocks.size() && (!stockRemoved); i++) {
            if (stocks.get(i).getName().equals(name)) {
                stocks.remove(stocks.get(i));
                stockRemoved = true;
            }
        }

        return stockRemoved;
    }
}
