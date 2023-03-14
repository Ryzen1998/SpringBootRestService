package com.blueLine.java.webServices.blueline.spingService.common.user.service.userExtService;

import com.blueLine.java.webServices.blueline.spingService.common.user.repository.userExtRepo.UserExtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserExtService implements  iUserExtService{
    private final UserExtRepository userExtRepository;
     @Autowired
    public UserExtService(UserExtRepository userExtRepository) {
        this.userExtRepository = userExtRepository;
    }

    @Override
    public void doNewUserAddedJob(Long id, String addedBy) {
        userExtRepository.newUserAddedJob(id,addedBy);
    }
}
