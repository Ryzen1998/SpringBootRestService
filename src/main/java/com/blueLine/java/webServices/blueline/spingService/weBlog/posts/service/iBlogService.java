package com.blueLine.java.webServices.blueline.spingService.weBlog.posts.service;

import com.blueLine.java.webServices.blueline.spingService.common.serviceResponse.ServiceResponse;
import com.blueLine.java.webServices.blueline.spingService.weBlog.posts.dto.PostDto;
import com.blueLine.java.webServices.blueline.spingService.weBlog.posts.dto.PostResponseDto;
import java.util.List;

public interface iBlogService {
    ServiceResponse<String> addNewPost(PostDto blog);
    ServiceResponse<List<PostResponseDto>> getAllBlogs();
}
