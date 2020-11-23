package edu.baylor.ecs.csi3471.service;

import edu.baylor.ecs.csi3471.dao.CommentDAO;
import edu.baylor.ecs.csi3471.dao.GenericDAO;
import edu.baylor.ecs.csi3471.model.Comment;

/**
 * @author owenmurphy
 */
public class CommentService {

    private GenericDAO<Comment> dao;

    public CommentService() {
        this.dao = new CommentDAO();
    }

    public CommentService(GenericDAO<Comment> dao) {
        this.dao = dao;
    }

    public GenericDAO<Comment> getDao() {
        return dao;
    }

    public void setDao(GenericDAO<Comment> dao) {
        this.dao = dao;
    }
}
