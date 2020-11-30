package edu.baylor.ecs.csi3471.service;

import edu.baylor.ecs.csi3471.dao.GenericDAO;
import edu.baylor.ecs.csi3471.dao.StockWatchListDAO;
import edu.baylor.ecs.csi3471.model.StockWatchList;

import java.util.List;

/**
 * this class injects the service for ${@link edu.baylor.ecs.csi3471.presentation.presentationLogic.StockController}
 * class
 *
 * @author owenmurphy
 */
public class StockWatchListService {

    /** uses the dao to access the stock watch list of the user */
    GenericDAO<StockWatchList> dao;

    /**
     * public constructor that initializes the dao to a new dao
     */
    public StockWatchListService() { this.dao = new StockWatchListDAO(); }

    /**
     * traverses the list watch lists and checks the watchlist has already been made
     * calls ${@link StockWatchListDAO#add(StockWatchList)} to add the watchlist to the
     * list of watch lists
     * @param watchList watch list to be added
     * @return true if the watch list was added, false o.w.
     */
    public boolean addWatchList(StockWatchList watchList) {

        if (this.dao.getAll().contains(watchList)) { return false; }

        this.dao.add(watchList);
        return true;
    }

    /**
     * traverses the list of watch list to delete the name of the watch-list passed
     * calls ${@link StockWatchListDAO#delete(StockWatchList)} to remove the watch list
     * if found
     * @param name name of watchlist to remove
     * @return true if watch list was delete, false o.w.
     */
    public boolean removeWatchList(String name) { return this.dao.getAll().removeIf(x -> x.getName().equals(name)); }

    /**
     * @return dao object used to access stock watch list data
     */
    public GenericDAO<StockWatchList> getDao() { return dao;}

    /**
     * sets the dao to the parameter passed in
     * @param dao dao to be set to
     */
    public void setDao(GenericDAO<StockWatchList> dao) { this.dao = dao; }

    /**
     * calls ${@link StockWatchListDAO#setAll(List)} to set the watch list to the
     * parameter passed in
     * @param list stock watch list to be set to
     */
    public void setWatchList(List<StockWatchList> list) { this.dao.setAll(list); }

    /**
     * searches the dao for the stock watch list given the list name
     * @param listName name of the watch list to search for
     * @return stock watch list if found, o.w. null
     */
    public StockWatchList findStockWatchList(String listName) {
        return this.dao.getAll().stream().filter(x-> x.getName().equals(listName)).findFirst().orElse(null);
    }

    /**
     * the method calls
     * ${@link edu.baylor.ecs.csi3471.presentation.presentationLogic.StockWatchListController#renameStockWatchList(String, String)}
     * to rename the watchlist to the newName
     * @param newName new name to be given to stock watch list
     * @param oldName old name to find the stock watch list
     */
    public void renameStockWatchList(String newName, String oldName) {
        this.dao.getAll().stream().filter(x -> x.getName().equals(oldName)).findFirst().ifPresent(list -> list.setName(newName));
    }
}
