package edu.baylor.ecs.csi3471.presentation.presentationLogic;

import edu.baylor.ecs.csi3471.model.Stock;
import edu.baylor.ecs.csi3471.service.StockService;

public class StockController {

    private Stock stock;

    private StockService service;



    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public StockService getService() {
        return service;
    }

    public void setService(StockService service) {
        this.service = service;
    }
}
