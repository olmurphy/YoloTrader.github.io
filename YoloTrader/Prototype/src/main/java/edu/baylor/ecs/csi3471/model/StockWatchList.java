package edu.baylor.ecs.csi3471.model;

import java.util.Date;
import java.util.List;

public class StockWatchList implements Comparable<StockWatchList> {

    private String name;
    private List<Stock> stockWatchList;
    private Date dateCreated;

    public StockWatchList(String name, Date dateCreated) {
        this.name = name;
        this.dateCreated = dateCreated;

        // there are no stocks upon a newly created stock watchList
        this.stockWatchList = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Stock> getStockWatchList() {
        return stockWatchList;
    }

    public void setStockWatchList(List<Stock> stockWatchList) {
        this.stockWatchList = stockWatchList;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    /**
     * FIXME: Need to add description for method
     *
     * @param o instance of another object
     * @return comparing two instances of a StockWatchList to impose ordering
     */
    @Override
    public int compareTo(StockWatchList o) {
        return this.name.compareTo(o.getName());
    }
}
