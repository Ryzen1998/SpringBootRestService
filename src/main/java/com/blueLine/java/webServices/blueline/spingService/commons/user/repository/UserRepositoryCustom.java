package com.blueLine.java.webServices.blueline.spingService.commons.user.repository;

import com.blueLine.java.webServices.blueline.spingService.commons.user.dto.SignupDto;
import com.blueLine.java.webServices.blueline.spingService.commons.user.enums.FilterUserBy;
import com.blueLine.java.webServices.blueline.spingService.commons.user.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepositoryCustom {
    List<User> getAllUsers();
    void addNewUser(SignupDto data);
    User findUserBy(FilterUserBy filter,String searchParameter);
    User getUserById(Long id);
    User updateUser(User user);
}
