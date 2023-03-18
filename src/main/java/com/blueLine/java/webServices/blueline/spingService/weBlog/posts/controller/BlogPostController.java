package com.blueLine.java.webServices.blueline.spingService.weBlog.posts.controller;

import com.blueLine.java.webServices.blueline.spingService.common.serviceResponse.ServiceResponse;
import com.blueLine.java.webServices.blueline.spingService.weBlog.posts.dto.PostDto;
import com.blueLine.java.webServices.blueline.spingService.weBlog.posts.dto.PostResponseDto;
import com.blueLine.java.webServices.blueline.spingService.weBlog.posts.model.Blog;
import com.blueLine.java.webServices.blueline.spingService.weBlog.posts.service.iBlogService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/blogpost")
public class BlogPostController {
    private final iBlogService blogService;
    public BlogPostController(iBlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("getallposts")
    public ServiceResponse<List<PostResponseDto>> getAllPosts(){
        ServiceResponse<List<PostResponseDto>>  response = blogService.getAllBlogs();
        return response;
    }
    @PostMapping("addnewpost")
    public ServiceResponse<String> addNewPost(@RequestBody @Valid PostDto post){
        if(post!=null){
            ServiceResponse<String> response = blogService.addNewPost(post);
            return response;
        }
        return new ServiceResponse<>(null,false,"Invalid Post",400);
    }
}
