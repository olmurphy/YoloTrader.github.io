package edu.baylor.ecs.csi3471.service;

import edu.baylor.ecs.csi3471.dao.GenericDAO;
import edu.baylor.ecs.csi3471.dao.StockWatchListDAO;
import edu.baylor.ecs.csi3471.model.StockWatchList;

import java.util.List;

/**
 * @author owenmurphy
 */
public class StockWatchListService {

    GenericDAO<StockWatchList> dao;

    public StockWatchListService() {
        this.dao = new StockWatchListDAO();
    }

    public StockWatchListService(GenericDAO<StockWatchList> dao) {
        this.dao = dao;
    }

    public void loadStockList(List<StockWatchList> list) {
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

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(listName)) {
                watchList = list.get(i);
            }
        }

        return watchList;
    }

    public boolean addWatchList(StockWatchList watchList) {

        List<StockWatchList> stockWatchLists = this.dao.getAll();

        boolean create = true;

        for (int i = 0; i < stockWatchLists.size(); i++) {
            if (stockWatchLists.get(i).getName().equals(watchList.getName())) {
                create = false;
            }
        }

        if (create) {
            this.dao.add(watchList);
        }

        return create;
    }

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

    public GenericDAO<StockWatchList> getDao() {
        return dao;
    }

    public void setDao(GenericDAO<StockWatchList> dao) {
        this.dao = dao;
    }

    public void setWatchList(List<StockWatchList> list) {
        this.dao.setAll(list);
    }
}
