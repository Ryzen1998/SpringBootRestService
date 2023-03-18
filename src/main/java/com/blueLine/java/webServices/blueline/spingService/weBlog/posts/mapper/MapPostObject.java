package com.blueLine.java.webServices.blueline.spingService.weBlog.posts.mapper;

import com.blueLine.java.webServices.blueline.spingService.weBlog.posts.dto.PostDto;
import com.blueLine.java.webServices.blueline.spingService.weBlog.posts.model.Blog;
import java.util.Date;

public class MapPostObject {
    public static class Map{
        public static Blog blogDtoToBlog(PostDto post){
            if(post!=null){
                Blog blog = new Blog();
                blog.setActive(false);
                blog.setTitle(post.getTitle());
                blog.setContent(post.getContent());
                blog.setGenre(post.getGenre());
                blog.setCreatedOn(new Date());
                blog.setCreatedByUser(0L);
                return blog;
            }
            return null;
        }
    }
}
