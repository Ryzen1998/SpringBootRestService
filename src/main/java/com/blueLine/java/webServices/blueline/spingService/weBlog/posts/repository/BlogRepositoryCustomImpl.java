package com.blueLine.java.webServices.blueline.spingService.weBlog.posts.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = false)
public class BlogRepositoryCustomImpl implements BlogRepositoryCustom{
}
