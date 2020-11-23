package edu.baylor.ecs.csi3471.dao;

import edu.baylor.ecs.csi3471.model.Comment;

import java.util.List;

/**
 * @author owenmurphy
 */

public class CommentDAO implements GenericDAO<Comment> {

    List<Comment> comments;

    @Override
    public List<Comment> getAll() {
        return this.comments;
    }

    @Override
    public void save(Comment comment) {
        // do nothing
    }

    @Override
    public void update(int index, Comment comment) {
        // do nothing
    }

    @Override
    public void delete(Comment comment) {
        this.comments.remove(comment);
    }

    @Override
    public void add(Comment comment) {
        this.comments.add(comment);
    }

    @Override
    public void setAll(List<Comment> t) {
        this.comments = t;
    }

    @Override
    public void saveAll() {
        // do nothing
    }

    @Override
    public void loadAll() {
        // do nothing
    }
}
