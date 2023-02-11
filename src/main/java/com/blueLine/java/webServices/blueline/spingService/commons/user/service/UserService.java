package com.blueLine.java.webServices.blueline.spingService.commons.user.service;

import com.blueLine.java.webServices.blueline.spingService.commons.user.dto.SignupDto;
import com.blueLine.java.webServices.blueline.spingService.commons.user.dto.UserDto;
import com.blueLine.java.webServices.blueline.spingService.commons.user.enums.FilterUserBy;
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
    public List<UserDto> getAllUsers() {
        List<User> userList = userRepository.getAllUsers();
        return castUserObj.userObjectConversion(userList);
    }

    @Override
    public String addUser(SignupDto data) {
        if(data!=null){
            if(userRepository.findUserBy(FilterUserBy.user_name,data.getUserName())!=null){
                return "Username is taken";
            } else if(userRepository.findUserBy(FilterUserBy.email,data.getEmail())!=null){
                return "Email already in use";
            } else if(userRepository.findUserBy(FilterUserBy.phone_number,data.getPhoneNumber())!=null){
                return "Phone number already exists";
            }else {
                userRepository.addNewUser(data);
                return String.format("Welcome %s",data.getUserName());
            }
        }
        return "oops! Something went wrong";
    }
}
