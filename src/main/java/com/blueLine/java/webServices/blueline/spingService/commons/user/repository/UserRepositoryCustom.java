package com.blueLine.java.webServices.blueline.spingService.commons.user.repository;

import com.blueLine.java.webServices.blueline.spingService.commons.user.dto.UserDto;
import com.blueLine.java.webServices.blueline.spingService.commons.user.model.User;

import java.util.List;

public interface UserRepositoryCustom {
    List<User> getAllUsers();
}
