package com.blueLine.java.webServices.blueline.spingService.weBlog.posts.repository;

import com.blueLine.java.webServices.blueline.spingService.weBlog.posts.model.Blog;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepositoryCustom {
    void addPost(Blog blog);
    List<Blog> getAllPosts();
}
