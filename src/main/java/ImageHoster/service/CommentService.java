package ImageHoster.service;


import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import ImageHoster.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    //Display all the comments posted on an image
    public List<Comment> ShowComments (Image image){
        return commentRepository.getAllCommentsByImage(image);
    }

    //This method posts a comment
    public void postComment(Comment comment){
        commentRepository.postComment(comment);
    }
}
