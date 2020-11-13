package edu.baylor.ecs.csi3471.model;

import java.util.Date;

public class Comment {

    private Date dateCreated;
    private String text;

    public Comment(Date dateCreated, String text) {
        this.dateCreated = dateCreated;
        this.text = text;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
