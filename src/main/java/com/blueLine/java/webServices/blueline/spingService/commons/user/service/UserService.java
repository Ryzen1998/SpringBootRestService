package com.blueLine.java.webServices.blueline.spingService.commons.user.service;

import com.blueLine.java.webServices.blueline.spingService.commons.user.dto.UserDto;
import com.blueLine.java.webServices.blueline.spingService.commons.user.model.User;
import com.blueLine.java.webServices.blueline.spingService.commons.user.objCast.CastUserObj;
import com.blueLine.java.webServices.blueline.spingService.commons.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements iUserService{
    private final UserRepository userRepository;
    private final CastUserObj castUserObj;
    @Autowired
    public UserService(UserRepository userRepository, CastUserObj castUserObj) {
        this.userRepository = userRepository;
        this.castUserObj = castUserObj;
    }

    @Override
    public List<UserDto> GetAllUsers() {
        List<User> userList = userRepository.getAllUsers();
        return castUserObj.userObjectConversion(userList);
    }
}
