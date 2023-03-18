package com.blueLine.java.webServices.blueline.spingService.weBlog.posts.repository;

import com.blueLine.java.webServices.blueline.spingService.weBlog.posts.model.Blog;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional(readOnly = false)
public class BlogRepositoryCustomImpl implements BlogRepositoryCustom{
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public void addPost(Blog blog) {
        try{
            entityManager.createNativeQuery
                    ("insert into blog_posts (created_by_user, content, created_on, is_active, title,genre) values (?1,?2,?3,?4,?5,?6)").
                    setParameter(1,blog.getCreatedByUser()).setParameter(2,blog.getContent()).setParameter(3,blog.getCreatedOn())
                    .setParameter(4,blog.isActive()).setParameter(5,blog.getTitle()).setParameter(6,blog.getGenre()).executeUpdate();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public List<Blog> getAllPosts() {
        List<Blog> result = new ArrayList<>();
        try{
            result = entityManager.createNativeQuery("select blog_posts.id, content,created_on,blog_posts.is_active,title,genre,created_by_user\n" +
                            "from blog_posts inner join user_data on blog_posts.created_by_user = user_data.id where user_data.is_active=?1",Blog.class).
                    setParameter(1,true)
                    .getResultList();

        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return result;
    }
}
