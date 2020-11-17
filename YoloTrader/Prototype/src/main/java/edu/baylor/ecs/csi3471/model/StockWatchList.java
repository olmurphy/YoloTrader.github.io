package edu.baylor.ecs.csi3471.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@XmlRootElement(name = "stockWatchList")
public class StockWatchList implements Comparable<StockWatchList> {

    /** name of stock watch list */
    private String name;

    /** date the stock watch list was created */
    private Date dateCreated;


    /** list of Stocks for watch list */
    @XmlElementWrapper(name = "ListOfStocks")
    @XmlElement(name = "AStock")
    private List<Stock> stockWatchList;

    public StockWatchList() {
        // do nothing
    }

    /**
     * constructor constructs instance of watchlist with parameters
     * @param name specified by user
     * @param dateCreated date the user created the watchlist
     */
    public StockWatchList(String name, Date dateCreated) {
        this.name = name;
        this.dateCreated = dateCreated;
        this.stockWatchList = new ArrayList<>();
    }

    /**
     * @return name of watchlist
     */
    public String getName() {
        return name;
    }

    /**
     * sets name of watch list
     * @param name specified by user
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the list of stocks of watch list
     */
    public List<Stock> getStockWatchList() {
        return stockWatchList;
    }

    /**
     * sets watch list
     * @param stockWatchList list of stocks specified by user
     */
    //public void setStockWatchList(List<Stock> stockWatchList) {
    //    this.stockWatchList = stockWatchList;
    //}

    /**
     * @return date the stock watch list was created by user
     */
    public Date getDateCreated() {
        return dateCreated;
    }

    /**
     * sets date created
     * @param dateCreated date the stock watch list was created
     */
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    /**
     * compares the name of two instances of watchlist to order them
     *
     * @param o instance of another stock watch list object
     * @return < 0 if this.name < o.getName()
     */
    @Override
    public int compareTo(StockWatchList o) {
        return this.name.compareTo(o.name);
    }


    // FIXME: delete
    public void addStock(Stock stock) {
        this.stockWatchList.add(stock);
    }

    @Override
    public String toString() {
        return "StockWatchList{" +
                "name='" + name + '\'' +
                ", dateCreated=" + dateCreated +
                ", stockWatchList=" + stockWatchList +
                '}';
    }
}
