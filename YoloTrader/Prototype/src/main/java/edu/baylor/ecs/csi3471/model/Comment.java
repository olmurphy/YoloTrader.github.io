package edu.baylor.ecs.csi3471.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;
import java.util.Objects;

/**
 * This class is representative of a comment created by a user.
 * It has the subject line, the text, and the date created that the user
 * has.
 *
 * @author owenmurphy
 */
@XmlRootElement(name = "comment")
@XmlType(propOrder = {"subject", "dateCreated", "text"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Comment {

    /** states the date an instance of Comment was created */
    private Date dateCreated;

    /** holds the date the user most recently modified the comment */
    private Date dateLastModified;

    /** stores the user's comments */
    private String text;

    /** stores the subject of the comment */
    private String subject;

    /**
     * Constructor constructs instance with test, dateCreated and subject passed in
     *
     * @param text description of comment
     * @param subject subject of comment
     */
    public Comment(String text, String subject) {
        this.text = text;
        this.subject = subject;
        this.dateCreated = new Date();
        this.dateLastModified = new Date();
    }

    public Comment() {
        // do nothing
    }

    /**
     *
     * @return date last modified
     */
    public Date getDateLastModified() {
        return dateLastModified;
    }

    /**
     * sets the date Last modified
     * @param dateLastModified date the user recently modifies the comment
     */
    public void setDateLastModified(Date dateLastModified) {
        this.dateLastModified = dateLastModified;
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

    @Override
    public String toString() {
        return "Comment{" +
                "dateCreated=" + dateCreated +
                ", text='" + text + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
