package edu.baylor.ecs.csi3471.presentation.presentationLogic;

import edu.baylor.ecs.csi3471.model.Comment;
import edu.baylor.ecs.csi3471.service.CommentService;

/**
 *
 * @author owenmurphy
 */
public class CommentController {

    /** comment the controller uses */
    private Comment comment;

    /** service the controller uses to process logic */
    private CommentService service;

    /**
     * @return comment the controller uses
     */
    public Comment getComment() { return comment; }

    /**
     * sets the comment
     * @param comment comment to be set to
     */
    public void setComment(Comment comment) { this.comment = comment; }

    /**
     * @return service the controller uses
     */
    public CommentService getService() { return service; }

    /**
     * sets the service
     * @param service service to be set to
     */
    public void setService(CommentService service) { this.service = service; }
}
