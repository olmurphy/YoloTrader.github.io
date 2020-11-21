package edu.baylor.ecs.csi3471.model;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * This Stock class has the ticker, name and date added
 *
 * @author owenmurphy
 */
@XmlRootElement(name = "stock")
@XmlAccessorType(XmlAccessType.FIELD)
public class Stock implements Comparable<Stock> {

    /** ticker of the stock that is used to search API */
    private String ticker;
    /** name of stock, that is, the company name */
    private String name;
    /** date the stock was added */
    private Date dateAdded;

    /** Stock as a list of comments made by user */
    @XmlElementWrapper(name = "commentList")
    @XmlElement(name = "comment")
    private List<Comment> comments;

    public Stock() {
        this.comments = new ArrayList<>();
    }

    /**
     * constructor constructs instance of stock with fields passed in
     *
     * @param ticker id for stock
     * @param name name of company
     * @param dateAdded date stock added to watchList
     */
    public Stock(String ticker, String name, Date dateAdded) {
        this.ticker = ticker;
        this.name = name;
        this.dateAdded = dateAdded;
        this.comments = new ArrayList<>();
    }

    /**
     * @return stock ticker
     */
    public String getTicker() {
        return ticker;
    }

    /**
     * set stock ticker
     * @param ticker unique id of stock
     */
    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    /**
     * @return name of company of stock
     */
    public String getName() {
        return name;
    }

    /**
     * set name of stock
     *
     * @param name name of stock
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return date the stock was added
     */
    public Date getDateAdded() {
        return dateAdded;
    }

    /**
     * set date the stock was added
     * @param dateAdded date the stock was added
     */
    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    /**
     * @return the list of comments of the stock
     */
    //public List<Comment> getComments() {
    //    return comments;
    //}

    /**
     * sets list of comments
     * @param comments list of comments made by user
     */
    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    /**
     * overridden function comparing two stock's tickers to order them
     *
     * @param o other stock to be compared to
     * @return < 0 if this.ticker < o.ticker
     */
    @Override
    public int compareTo(Stock o) {
        return this.ticker.compareTo(o.ticker);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stock stock = (Stock) o;
        return Objects.equals(ticker, stock.ticker) &&
                Objects.equals(name, stock.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticker, name);
    }

    @Override
    public String toString() {
        return "Stock{" +
                "ticker='" + ticker + '\'' +
                ", name='" + name + '\'' +
                ", dateAdded=" + dateAdded +
                ", comments=" + comments +
                '}';
    }
}
