package com.blueLine.java.webServices.blueline.spingService.common.user.controller;

import com.blueLine.java.webServices.blueline.spingService.common.security.blueLineAuthenticationContext.blueLineAuthContext;
import com.blueLine.java.webServices.blueline.spingService.common.serviceResponse.ServiceResponse;
import com.blueLine.java.webServices.blueline.spingService.common.user.dto.SignupDto;
import com.blueLine.java.webServices.blueline.spingService.common.user.dto.UserDto;
import com.blueLine.java.webServices.blueline.spingService.common.user.enums.Role;
import com.blueLine.java.webServices.blueline.spingService.common.user.service.userService.iUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {
    private final iUserService _userService;
    @Autowired
    public UserController(iUserService userService) {
        _userService = userService;
    }

    @GetMapping("getallusers")
    public ServiceResponse<List<UserDto>> getAllUsers(){

        ServiceResponse<List<UserDto>> response = _userService.getAllUsers();
        return  response;
    }

    @PostMapping("createuser")
    public ServiceResponse<String> createUser(@Valid @RequestBody SignupDto data){

        if(blueLineAuthContext.AuthContext.userRoleIs(Role.ADMIN)) {
            ServiceResponse<String> response = _userService.addUser(data);
            return response;
        }
        return new ServiceResponse<>(null,false,
                "Method Not Allowed For Your Profile",400);
    }
    @PutMapping("updateuser")
    public ServiceResponse<UserDto> updateUser(@Valid @RequestBody UserDto data){

        if( blueLineAuthContext.AuthContext.userRoleIs(Role.ADMIN)
                ||
                blueLineAuthContext.AuthContext.userEmailIs(data.getEmail())) {

            ServiceResponse<UserDto> response = _userService.updateUser(data);
            return response;
        }
        return new ServiceResponse<>(null,false,
                "Method Not Allowed For Your Profile",400);
    }
    @DeleteMapping("removeuser/{id}")
    public ServiceResponse<Boolean> removeUser(@Valid @PathVariable Long id){

        if( blueLineAuthContext.AuthContext.userRoleIs(Role.ADMIN)) {
            ServiceResponse<Boolean> response = _userService.removeUser(id);
            return response;
        }
        return new ServiceResponse<>(null,false,
                "Method Not Allowed For Your Profile",400);
    }

}
