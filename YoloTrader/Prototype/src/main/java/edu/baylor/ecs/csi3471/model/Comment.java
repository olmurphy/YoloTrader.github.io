package edu.baylor.ecs.csi3471.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;
import java.util.Objects;

@XmlRootElement(name = "comment")
@XmlType(propOrder = {"subject", "dateCreated", "text"})
public class Comment {

    /** states the date an instance of Comment was created */
    private Date dateCreated;

    /** stores the user's comments */
    private String text;

    /** stores the subject of the comment */
    private String subject;

    /*
     * Constructor constructs instance with test, dateCreated and subject passed in
     *
     * @param dateCreated date comment created
     * @param text description of comment
     * @param subject subject of comment
     */
    /*public Comment(Date dateCreated, String text, String subject) {
        this.dateCreated = dateCreated;
        this.text = text;
        this.subject = subject;
    }*/

    public Comment() {
        // do nothing
    }

    /**
     * @return date comment was created
     */
    public Date getDateCreated() {
        return dateCreated;
    }

    /**
     * sets the date comment was created
     *
     * @param dateCreated date comment was created
     */
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    /**
     * @return description of comment
     */
    public String getText() {
        return text;
    }

    /**
     * sets description of comment
     *
     * @param text description of comment
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return the subject of the comment
     */
    public String getSubject() {
        return subject;
    }

    /**
     * sets subject of comment
     *
     * @param subject subject of comment
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return Objects.equals(dateCreated, comment.dateCreated) &&
                Objects.equals(text, comment.text) &&
                Objects.equals(subject, comment.subject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateCreated, text, subject);
    }
}
