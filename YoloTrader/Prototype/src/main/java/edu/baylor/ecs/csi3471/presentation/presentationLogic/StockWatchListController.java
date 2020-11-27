package edu.baylor.ecs.csi3471.presentation.presentationLogic;

import edu.baylor.ecs.csi3471.model.StockWatchList;
import edu.baylor.ecs.csi3471.service.StockWatchListService;

import java.util.List;

/**
 * this class defines the operations the user can perform on a watch list
 * @author owenmurphy
 */
public class StockWatchListController {

    /** stock watch list the controller is using */
    private StockWatchList stockWatchList;

    /** service that the controller uses to handle logic */
    private StockWatchListService service;

    /**
     * constructor initializes a service
     */
    public StockWatchListController() {
        this.service = new StockWatchListService();
        this.stockWatchList = new StockWatchList();
    }

    /**
     * calls ${@link StockWatchListService} to add watch list to user's
     * list of watch lists
     * @param list list to add to user's list of watch lists
     * @return true if watch list was added, false o.w.
     * */
    public boolean addWatchList(StockWatchList list) {
        return this.service.addWatchList(list);
    }

    /**
     * calls ${@link StockWatchListService} to remove watch list
     * from user's list of watch lists
     * @param name name of watch list to find and remove
     * @return true if watch list was deleted, false o.w.
     */
    public boolean removeWatchList(String name) {
        return this.service.removeWatchList(name);
    }

    /**
     * @return watch list the controller is using
     */
    public StockWatchList getStockWatchList() {
        return stockWatchList;
    }

    /**
     * sets the watch list of controller
     * @param stockWatchList watch list to be set to
     */
    public void setStockWatchList(StockWatchList stockWatchList) {
        this.stockWatchList = stockWatchList;
    }


    /**
     * @return the service the controller users
     */
    public StockWatchListService getService() {
        return service;
    }

    /**
     * sets the service the user is using
     * @param service service to be set to
     */
    public void setService(StockWatchListService service) {
        this.service = service;
    }

    /**
     * calls ${@link StockWatchListService} to find the watch list given
     * the name
     * @param listName name of watch list to find
     * @return an instance of watch list if found, null o.w.
     */
    public StockWatchList findStockWatchList(String listName) {
        return service.findStockWatchList(listName);
    }

    /**
     * calls ${@link StockWatchListService} to rename to watch list to
     * the newName given
     * @param newName name the stock watch list will be set to
     * @param oldName name of the stock watch list currently to find it
     */
    public void renameStockWatchList(String newName, String oldName) { service.renameStockWatchList(newName, oldName); }

    /**
     * calls ${@link StockWatchListService} to load a list of stock watch lists
     * of the user when the application loads
     * @param list list of stock watch lists to be set to
     */
    public void loadStockLists(List<StockWatchList> list) {
        this.service.setWatchList(list);
    }
}
