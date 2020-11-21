package edu.baylor.ecs.csi3471.service;

import edu.baylor.ecs.csi3471.dao.CommentDAO;
import edu.baylor.ecs.csi3471.dao.CommentDAOImpl;

/**
 * @author owenmurphy
 */
public class CommentService {

    private CommentDAO dao;

    public CommentService() {
        this.dao = new CommentDAOImpl();
    }

    public CommentService(CommentDAO dao) {
        this.dao = dao;
    }

    public CommentDAO getDao() {
        return dao;
    }

    public void setDao(CommentDAO dao) {
        this.dao = dao;
    }
}
