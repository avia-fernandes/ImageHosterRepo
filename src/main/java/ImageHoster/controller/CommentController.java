package ImageHoster.controller;


import ImageHoster.model.Comment;
import ImageHoster.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private ImageController imageController;

    @RequestMapping("/image/{imageId}/{imageTitle}/comments")
    public String postComment(Comment comment, @RequestParam("imageId") Integer imageId, @RequestParam("title") String imageTitle, Model model){
        commentService.postComment(comment);
        imageController.showImage(imageId, imageTitle, model);
        return "images/image";
    }

}

