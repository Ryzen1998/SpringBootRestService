package com.blueLine.java.webServices.blueline.spingService.weBlog.posts.service;

import com.blueLine.java.webServices.blueline.spingService.common.security.blueLineAuthenticationContext.blueLineAuthContext;
import com.blueLine.java.webServices.blueline.spingService.common.serviceResponse.ServiceResponse;
import com.blueLine.java.webServices.blueline.spingService.common.user.enums.FilterUserBy;
import com.blueLine.java.webServices.blueline.spingService.common.user.service.userService.iUserService;
import com.blueLine.java.webServices.blueline.spingService.weBlog.genre.service.iGenreService;
import com.blueLine.java.webServices.blueline.spingService.weBlog.posts.dto.PostDto;
import com.blueLine.java.webServices.blueline.spingService.weBlog.posts.dto.PostResponseDto;
import com.blueLine.java.webServices.blueline.spingService.weBlog.posts.mapper.MapPostObject;
import com.blueLine.java.webServices.blueline.spingService.weBlog.posts.model.Blog;
import com.blueLine.java.webServices.blueline.spingService.weBlog.posts.repository.BlogRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
public class BlogService implements iBlogService{
    private final BlogRepository blogRepository;
    private final iUserService userService;
    private final iGenreService genreService;
    public BlogService(BlogRepository blogRepository, iUserService userService, iGenreService genreService) {
        this.blogRepository = blogRepository;
        this.userService = userService;
        this.genreService = genreService;
    }

    @Override
    public ServiceResponse<String> addNewPost(PostDto blog) {
        if(blog!=null && genreService.getGenreById(blog.getGenre()).getResultData()!=null){
            Blog blogInstance = MapPostObject.Map.blogDtoToBlog(blog);
                 blogInstance.setCreatedByUser(
                         userService.findUserBy(FilterUserBy.email,blueLineAuthContext.AuthContext.getEmail()).getResultData().getId()
                         );
              blogRepository.addPost(blogInstance);
            return new ServiceResponse<>(null,"Success");
        }
        return new ServiceResponse<>(null,"Invalid Request, Post has been Declined");
    }

    @Override
    public ServiceResponse<List<PostResponseDto>> getAllBlogs() {
       List<Blog> postsList = blogRepository.getAllPosts();
       if(!postsList.isEmpty()){
           List<PostResponseDto> response = new ArrayList<>();
           postsList.forEach(
                   (x)-> response.add(
                            new PostResponseDto(
                            x.getTitle(),
                            x.getContent(),
                            genreService.getGenreById(x.getGenre()).getResultData().getName(),
                            userService.findUserById(x.getCreatedByUser()).getResultData().getUserName(),
                            x.getCreatedOn()))
                   );
           return new ServiceResponse<>(response,"Success");
       }
       return new ServiceResponse<>(null,false,"No Posts Yet",404);
    }
}
