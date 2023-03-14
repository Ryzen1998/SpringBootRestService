package com.blueLine.java.webServices.blueline.spingService.common.user.repository.userRepo;

import com.blueLine.java.webServices.blueline.spingService.common.user.dto.SignupDto;
import com.blueLine.java.webServices.blueline.spingService.common.user.enums.FilterUserBy;
import com.blueLine.java.webServices.blueline.spingService.common.user.enums.Role;
import com.blueLine.java.webServices.blueline.spingService.common.user.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepositoryCustom {
    List<User> getAllUsers();
    void addNewUser(SignupDto data);
    User findUserBy(FilterUserBy filter,String searchParameter);
    User getUserById(Long id);
    User updateUser(User user);
    boolean removeUserById(Long id);
    Role getUserRoleByEmail(String email);
}
