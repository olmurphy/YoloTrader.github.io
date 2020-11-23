package edu.baylor.ecs.csi3471.presentation.presentationLogic;

import edu.baylor.ecs.csi3471.model.Profile;
import edu.baylor.ecs.csi3471.model.StockWatchList;
import edu.baylor.ecs.csi3471.service.StockWatchListService;

import java.util.List;

/**
 * @author owenmurphy
 */
public class StockWatchListController {

    private StockWatchList stockWatchList;

    private StockWatchListService service;

    public StockWatchListController() {
        this.service = new StockWatchListService();
        this.stockWatchList = new StockWatchList();
    }

    public void loadStockLists(List<StockWatchList> list) {
        this.service.loadStockList(list);
    }

    public StockWatchListController(StockWatchList stockWatchList, StockWatchListService service) {
        this.stockWatchList = stockWatchList;
        this.service = service;
    }

    public boolean addWatchList(StockWatchList list) {
        return this.service.addWatchList(list);
    }

    public boolean removeWatchList(String name) {
        return this.service.removeWatchList(name);
    }

    public StockWatchList getStockWatchList() {
        return stockWatchList;
    }

    public StockWatchList findStockWatchList(String listName) {
        return stockWatchList;
    }

    public void setStockWatchList(StockWatchList stockWatchList) {
        this.stockWatchList = stockWatchList;
    }

    public StockWatchListService getService() {
        return service;
    }

    public void setService(StockWatchListService service) {
        this.service = service;
    }
}
