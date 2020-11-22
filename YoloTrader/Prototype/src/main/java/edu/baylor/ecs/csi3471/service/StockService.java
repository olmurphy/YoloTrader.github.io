package edu.baylor.ecs.csi3471.service;

import edu.baylor.ecs.csi3471.dao.StockDAO;
import edu.baylor.ecs.csi3471.dao.StockDAOImpl;
import edu.baylor.ecs.csi3471.model.Stock;
import edu.baylor.ecs.csi3471.model.StockWatchList;

/**
 * @author owenmurphy
 */
public class StockService {

    private StockDAO dao;

    public StockService() {
        this.dao = new StockDAOImpl();
    }

    public StockService(StockDAO dao) {
        this.dao = dao;
    }

    public StockDAO getDao() {
        return dao;
    }

    public void setDao(StockDAO dao) {
        this.dao = dao;
    }

    public boolean addStock(Stock stock, StockWatchList stockWatchList) {

        for () {

        }


    }

    public boolean removeStock(Stock stock) {
        return false;
    }

}
