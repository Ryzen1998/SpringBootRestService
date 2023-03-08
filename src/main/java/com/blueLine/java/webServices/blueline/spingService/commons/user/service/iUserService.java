package com.blueLine.java.webServices.blueline.spingService.commons.user.service;

import com.blueLine.java.webServices.blueline.spingService.commons.user.dto.SignupDto;
import com.blueLine.java.webServices.blueline.spingService.commons.user.dto.UserDto;

import java.util.List;

public interface iUserService {

     List<UserDto> getAllUsers();
     String addUser(SignupDto data);
     UserDto updateUser(UserDto data);
}
