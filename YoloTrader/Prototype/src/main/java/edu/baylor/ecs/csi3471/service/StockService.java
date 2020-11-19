package edu.baylor.ecs.csi3471.service;

import edu.baylor.ecs.csi3471.dao.StockDAO;
import edu.baylor.ecs.csi3471.dao.StockDAOImpl;

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
}
