package edu.baylor.ecs.csi3471.presentation.presentationLogic;

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

    public StockWatchListController(StockWatchList stockWatchList, StockWatchListService service) {
        this.stockWatchList = stockWatchList;
        this.service = service;
    }

    public boolean addWatchList(StockWatchList list) {
        return this.service.addWatchList(list);
    }

    public StockWatchList getStockWatchList() {
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

    public void setListStockWatchList(List<StockWatchList> list) {
        this.service.setWatchList(list);
    }
}
