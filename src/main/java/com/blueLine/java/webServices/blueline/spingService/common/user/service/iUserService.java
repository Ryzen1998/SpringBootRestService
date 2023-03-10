package com.blueLine.java.webServices.blueline.spingService.common.user.service;

import com.blueLine.java.webServices.blueline.spingService.common.serviceResponse.ServiceResponse;
import com.blueLine.java.webServices.blueline.spingService.common.user.dto.SignupDto;
import com.blueLine.java.webServices.blueline.spingService.common.user.dto.UserDto;

import java.util.List;

public interface iUserService {

    ServiceResponse<List<UserDto>> getAllUsers();
    ServiceResponse<String> addUser(SignupDto data);
    ServiceResponse<UserDto> updateUser(UserDto data);
}
