package com.blueLine.java.webServices.blueline.spingService.common.user.service.userService;

import com.blueLine.java.webServices.blueline.spingService.common.serviceResponse.ServiceResponse;
import com.blueLine.java.webServices.blueline.spingService.common.user.dto.SignupDto;
import com.blueLine.java.webServices.blueline.spingService.common.user.dto.UserDto;
import com.blueLine.java.webServices.blueline.spingService.common.user.enums.FilterUserBy;
import com.blueLine.java.webServices.blueline.spingService.common.user.enums.Role;
import com.blueLine.java.webServices.blueline.spingService.common.user.model.User;

import java.util.List;

public interface iUserService {

    ServiceResponse<List<UserDto>> getAllUsers();
    ServiceResponse<String> addUser(SignupDto data);
    ServiceResponse<UserDto> updateUser(UserDto data);
    ServiceResponse<Boolean> removeUser(Long id);
    ServiceResponse<User> findUserBy(FilterUserBy filterUserBy, String searchParameter);
    ServiceResponse<Role> findUserRoleByEmail(String email);
    ServiceResponse<User> findUserById(Long id);
}
