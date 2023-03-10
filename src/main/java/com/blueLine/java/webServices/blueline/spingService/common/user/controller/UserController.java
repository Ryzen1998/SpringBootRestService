package com.blueLine.java.webServices.blueline.spingService.common.user.controller;

import com.blueLine.java.webServices.blueline.spingService.common.serviceResponse.ServiceResponse;
import com.blueLine.java.webServices.blueline.spingService.common.user.dto.SignupDto;
import com.blueLine.java.webServices.blueline.spingService.common.user.dto.UserDto;
import com.blueLine.java.webServices.blueline.spingService.common.user.service.iUserService;
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

    @GetMapping("getusers")
    public ServiceResponse<List<UserDto>> getAllUsers(){
        ServiceResponse<List<UserDto>> response = _userService.getAllUsers();
        return  response;
    }

    @PostMapping("createuser")
    public ServiceResponse<String> createUser(@Valid @RequestBody SignupDto data){
        ServiceResponse<String> response = _userService.addUser(data);
        return response;
    }
    @PutMapping("updateuser")
    public ServiceResponse<UserDto> updateUser(@Valid @RequestBody UserDto data){
        ServiceResponse<UserDto> response = _userService.updateUser(data);
        return response;
    }
}
