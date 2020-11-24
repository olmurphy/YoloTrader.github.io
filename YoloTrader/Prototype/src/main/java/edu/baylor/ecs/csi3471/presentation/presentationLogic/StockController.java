package edu.baylor.ecs.csi3471.presentation.presentationLogic;

import edu.baylor.ecs.csi3471.model.Stock;
import edu.baylor.ecs.csi3471.model.StockWatchList;
import edu.baylor.ecs.csi3471.service.StockService;

/**
 * @author owenmurphy
 */
public class StockController {

    private Stock stock;

    private StockService service;

    public StockController() {
        this.service = new StockService();
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public StockService getService() {
        return service;
    }

    public void setService(StockService service) {
        this.service = service;
    }

    public boolean addStock(Stock stock, StockWatchList stockWatchList) {
        return service.addStock(stock, stockWatchList);
    }

    public boolean removeStock(String name, StockWatchList list) {
        return this.service.removeStock(name, list);
    }
}
