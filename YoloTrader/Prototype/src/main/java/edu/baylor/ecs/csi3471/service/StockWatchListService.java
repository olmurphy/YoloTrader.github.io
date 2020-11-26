package edu.baylor.ecs.csi3471.service;

import edu.baylor.ecs.csi3471.dao.GenericDAO;
import edu.baylor.ecs.csi3471.dao.StockWatchListDAO;
import edu.baylor.ecs.csi3471.model.StockWatchList;

import java.util.List;

/**
 * @author owenmurphy
 */
public class StockWatchListService {

    /** uses the dao to access the stock watch list of the user */
    GenericDAO<StockWatchList> dao;

    /**
     * public constructor that initializes the dao to a new dao
     */
    public StockWatchListService() {
        this.dao = new StockWatchListDAO();
    }

    /**
     * traverses the list watch lists and checks the watchlist has already been made
     * calls ${@link StockWatchListDAO#add(StockWatchList)} to add the watchlist to the
     * list of watch lists
     * @param watchList watch list to be added
     * @return true if the watch list was added, false o.w.
     */
    public boolean addWatchList(StockWatchList watchList) {

        List<StockWatchList> stockWatchLists = this.dao.getAll();

        for (StockWatchList stockWatchList : stockWatchLists) {
            if (stockWatchList.getName().equals(watchList.getName())) {
                return false;
            }
        }

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
    public boolean removeWatchList(String name) {
        List<StockWatchList> list = this.dao.getAll();

        for (StockWatchList stockWatchList : list) {
            if (stockWatchList.getName().equals(name)) {
                this.dao.delete(stockWatchList);
                return true;
            }
        }

        return false;
    }

    /**
     * @return dao object used to access stock watch list data
     */
    public GenericDAO<StockWatchList> getDao() {
        return dao;
    }

    /**
     * sets the dao to the parameter passed in
     * @param dao dao to be set to
     */
    public void setDao(GenericDAO<StockWatchList> dao) {
        this.dao = dao;
    }

    /**
     * calls ${@link StockWatchListDAO#setAll(List)} to set the watch list to the
     * parameter passed in
     * @param list stock watch list to be set to
     */
    public void setWatchList(List<StockWatchList> list) {
        this.dao.setAll(list);
    }

    /**
     * searches the dao for the stock watch list given the list name
     * @param listName name of the watch list to search for
     * @return stock watch list if found, o.w. null
     */
    public StockWatchList findStockWatchList(String listName) {

        List<StockWatchList> list = this.dao.getAll();
        StockWatchList watchList;

        for (int i = 0; i < list.size(); i++) { // short circuit the loop
            if (list.get(i).getName().equals(listName)) {
                watchList = list.get(i);
                return watchList;
            }
        }

        return null;
    }

    public void renameStockWatchList(String newName, String oldName) {
        List<StockWatchList> list = this.dao.getAll();

        // traverse the watch lists
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(oldName)) {
                list.get(i).setName(newName);
                return; // short circuit the loop for performance
            }
        }
    }
}
