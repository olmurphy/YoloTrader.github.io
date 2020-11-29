package edu.baylor.ecs.csi3471.presentation.presentationLogic;

import edu.baylor.ecs.csi3471.model.Stock;
import edu.baylor.ecs.csi3471.model.StockWatchList;
import edu.baylor.ecs.csi3471.service.StockService;

/**
 * @author owenmurphy
 */
public class StockController {

    /** controller controls a stock */
    private Stock stock;

    /** service to call for logic processing */
    private StockService service;

    /**
     * constructor to set the service
     */
    public StockController() { this.service = new StockService(); }

    /**
     * @return Stock the controller uses
     */
    public Stock getStock() { return stock; }

    /**
     * sets the stock
     * @param stock stock to be set to
     */
    public void setStock(Stock stock) { this.stock = stock; }

    /**
     * @return service the controller uses
     */
    public StockService getService() { return service; }

    /**
     * sets the service
     * @param service service to be set to
     */
    public void setService(StockService service) { this.service = service; }

    /**
     * calls @{@link StockService} to add stock to given watch list
     * @param stock stock to be added to watch list
     * @param stockWatchList watch list to contain the stock
     * @return true if the watch list was added, false o.w.
     */
    public boolean addStock(Stock stock, StockWatchList stockWatchList) { return service.addStock(stock, stockWatchList); }

    /**
     * calls @{@link StockService} to remove the stock from the watch list
     * @param name list of stock name
     * @param list watch list that contains the stock
     * @return true if stock was removed, false o.w.
     */
    public boolean removeStock(String name, StockWatchList list) { return this.service.removeStock(name, list); }
}
