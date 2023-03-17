package com.blueLine.java.webServices.blueline.spingService.weBlog.posts.repository;

import com.blueLine.java.webServices.blueline.spingService.weBlog.posts.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface  BlogRepository extends JpaRepository<Blog,Long>,BlogRepositoryCustom {
}
