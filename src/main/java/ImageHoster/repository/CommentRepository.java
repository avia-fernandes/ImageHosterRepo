package ImageHoster.repository;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.BeanCreationException;


import javax.persistence.*;
import java.util.List;

@Repository
public class CommentRepository  {
    @PersistenceUnit(unitName = "imageHoster")
    private EntityManagerFactory emf;

    public Comment postComment(Comment newComment) throws BeanCreationException {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(newComment);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
        return newComment;
    }

    //Method to show all comments posted on an image

    public List<Comment> getAllCommentsByImage (Image image) throws BeanCreationException {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Comment> query = em.createQuery("SELECT c from Comment c where c.image = :image", Comment.class);
        List<Comment> resultList = query.getResultList();

        return resultList;
    }


}
