package edu.baylor.ecs.csi3471.presentation.presentationLogic;

import edu.baylor.ecs.csi3471.model.Comment;
import edu.baylor.ecs.csi3471.service.CommentService;


/**
 * @author owenmurphy
 */
public class CommentController {

    private Comment comment;

    private CommentService service;

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public CommentService getService() {
        return service;
    }

    public void setService(CommentService service) {
        this.service = service;
    }
}
