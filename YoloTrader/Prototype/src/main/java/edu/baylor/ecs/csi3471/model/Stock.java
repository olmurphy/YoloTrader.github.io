package edu.baylor.ecs.csi3471.model;

import java.util.Date;
import java.util.List;

// This class is representative of a stock.
public class Stock implements Comparable<Stock> {

    private String ticker;
    private String name;
    private Date dateAdded;

    private List<Comment> comments;

    public Stock(String ticker, String name, Date dateAdded) {
        this.ticker = ticker;
        this.name = name;
        this.dateAdded = dateAdded;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    // this function returns a negative value if o is less than this,
    // zero if this is equal to o, and positive if this is greater than o.
    @Override
    public int compareTo(Stock o) {

        // Compare by ticker, before comparing by name.
        int rtrn = this.ticker.compareTo(o.ticker);

        if(rtrn == 0) {
            rtrn = this.name.compareTo(o.name);
        }
        return rtrn;
    }
}
