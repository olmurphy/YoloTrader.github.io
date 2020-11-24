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

        boolean create = true;
        for (int i = 0; i < stockWatchLists.size() && create; i++) {
            if (stockWatchLists.get(i).getName().equals(watchList.getName())) {
                create = false;
            }
        }

        if (create) {
            this.dao.add(watchList);
        }

        return create;
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

        boolean listExists = false;
        for (int index = 0; index < list.size() && !listExists; index++) {
            if (list.get(index).getName().equals(name)) {
                this.dao.delete(list.get(index));
                listExists = true;
            }
        }

        return listExists;
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
        StockWatchList watchList = null;

        boolean found = false;
        for (int i = 0; !found && i < list.size(); i++) { // short circuit the loop
            if (list.get(i).getName().equals(listName)) {
                watchList = list.get(i);
                found = true; // found the watch list, exit the loop
            }
        }

        return watchList;
    }
}
