package edu.baylor.ecs.csi3471.service;

import edu.baylor.ecs.csi3471.dao.GenericDAO;
import edu.baylor.ecs.csi3471.dao.StockDAO;
import edu.baylor.ecs.csi3471.model.Stock;
import edu.baylor.ecs.csi3471.model.StockWatchList;

import java.util.List;

/**
 * this class
 * @author owenmurphy
 */
public class StockService {

    private GenericDAO<Stock> dao;

    public StockService() {
        this.dao = new StockDAO();
    }

    public StockService(GenericDAO<Stock> dao) {
        this.dao = dao;
    }

    public GenericDAO<Stock> getDao() {
        return dao;
    }

    public void setDao(GenericDAO<Stock> dao) {
        this.dao = dao;
    }

    /**
     * injected service from the stock controller. checks if the stock passed
     * in is a unique stock in the watch list wanted to add it in
     * if so, it adds the stock, else do nothing, returns true if added, false o.w.
     * @param stock stock to be added to the watchlist
     * @param stockWatchList watchlist to have the stock added to
     * @return true if stock added, false o.w.
     */
    public boolean addStock(Stock stock, StockWatchList stockWatchList) {
        this.dao.setAll(stockWatchList.getStockList()); // set the dao

        List<Stock> stocks = this.dao.getAll(); // get stock from the dao

        boolean isUnique = true;

        // check if the stock is unique
        for (Stock value : stocks) {
            if (value.equals(stock)) {
                isUnique = false;
            }
        }

        if (isUnique) {
            this.dao.add(stock);
        }

        return isUnique;
    }

    public boolean removeStock(Stock stock) {
        return false;
    }

}
