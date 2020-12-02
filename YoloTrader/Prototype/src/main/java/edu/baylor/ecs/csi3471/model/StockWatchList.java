package edu.baylor.ecs.csi3471.model;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * This class is the list of stocks, that is, a stock watch list
 *
 * @author owenmurphy
 */
@XmlRootElement(name = "watchList")
@XmlAccessorType(XmlAccessType.FIELD)
public class StockWatchList implements Comparable<StockWatchList> {

    /** name of stock watch list */
    private String name;

    /** date the stock watch list was created */
    private Date dateCreated;

    /** list of Stocks for watch list */
    @XmlElementWrapper(name = "stockList")
    @XmlElement(name = "stock")
    private List<Stock> stockList;

    /**
     * Constructor
     * sets the date created
     */
    public StockWatchList() { dateCreated = new Date(); }

    /**
     * constructor constructs instance of watchlist with parameters
     * @param name specified by user
     * @param dateCreated date the user created the watchlist
     */
    public StockWatchList(String name, Date dateCreated) {
        this.name = name;
        this.dateCreated = dateCreated;
        this.stockList = new ArrayList<>();
    }

    /**
     * @return name of watchlist
     */
    public String getName() { return name; }

    /**
     * sets name of watch list
     * @param name specified by user
     */
    public void setName(String name) { this.name = name; }

    /**
     * @return the list of stocks of watch list
     */
    public List<Stock> getStockList() { return stockList; }

    /**
     * sets watch list
     * @param stockList list of stocks specified by user
     */
    public void setStockList(List<Stock> stockList) { this.stockList = stockList; }

    /**
     * @return date the stock watch list was created by user
     */
    public Date getDateCreated() { return dateCreated; }

    /**
     * sets date created
     * @param dateCreated date the stock watch list was created
     */
    public void setDateCreated(Date dateCreated) { this.dateCreated = dateCreated; }

    /**
     * compares the name of two instances of watchlist to order them
     *
     * @param o instance of another stock watch list object
     * @return < 0 if this.name < o.getName()
     */
    @Override
    public int compareTo(StockWatchList o) { return this.name.compareTo(o.name); }

    /**
     * tests if two instances of stock watch lists are the same based on their name attribute
     * @param o instance of profile to check
     * @return true if two have same email, false o.w.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockWatchList watchList = (StockWatchList) o;
        return Objects.equals(name, watchList.name);
    }

    /**
     * produces hash code for instance of Stock watch lists based on its name attribute
     * @return hash value calculated from email
     */
    @Override
    public int hashCode() { return Objects.hash(name); }

    /** @return stock watch list and all its attributes in a string */
    @Override
    public String toString() { return "StockWatchList{name='" + name + "', dateCreated=" + dateCreated + ", stockList=" + stockList + '}'; }
}
