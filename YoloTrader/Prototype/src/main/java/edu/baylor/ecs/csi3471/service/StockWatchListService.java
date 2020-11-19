package edu.baylor.ecs.csi3471.service;

import edu.baylor.ecs.csi3471.dao.StockWatchListDAO;
import edu.baylor.ecs.csi3471.dao.StockWatchListDAOImpl;
import edu.baylor.ecs.csi3471.model.StockWatchList;

import java.util.List;

public class StockWatchListService {

    StockWatchListDAO dao;

    public StockWatchListService() {
        this.dao = new StockWatchListDAOImpl();
    }

    public StockWatchListService(StockWatchListDAO dao) {
        this.dao = dao;
    }

    public boolean addWatchList(StockWatchList watchList) {

        List<StockWatchList> stockWatchLists = this.dao.getAllWatchLists();

        boolean create = true;
        for (int i = 0; i < stockWatchLists.size(); i++) {
            if (stockWatchLists.get(i).getName().equals(watchList.getName())) {
                create = false;
            }
        }

        if (create) {
            this.dao.addWatchList(watchList);
        }

        return create;
    }

    public StockWatchListDAO getDao() {
        return dao;
    }

    public void setDao(StockWatchListDAO dao) {
        this.dao = dao;
    }

    public void setWatchList(List<StockWatchList> list) {
        this.dao.setWatchList(list);
    }

}
