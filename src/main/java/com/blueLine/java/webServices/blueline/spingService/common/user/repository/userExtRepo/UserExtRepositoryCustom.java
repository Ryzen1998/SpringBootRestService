package com.blueLine.java.webServices.blueline.spingService.common.user.repository.userExtRepo;

import org.springframework.stereotype.Repository;

@Repository
public interface UserExtRepositoryCustom {
    void newUserAddedJob(Long id,String addedBy);
}
