package com.blueLine.java.webServices.blueline.spingService.commons.user.controller;

import com.blueLine.java.webServices.blueline.spingService.commons.serviceResponse.ServiceResponse;
import com.blueLine.java.webServices.blueline.spingService.commons.user.dto.SignupDto;
import com.blueLine.java.webServices.blueline.spingService.commons.user.dto.UserDto;
import com.blueLine.java.webServices.blueline.spingService.commons.user.service.iUserService;
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
        List<UserDto> response = _userService.getAllUsers();
        var test = new ServiceResponse<List<UserDto>>(response, "success");
        if(response!=null)
            return new ServiceResponse<List<UserDto>>(response, "success");
        else
            return new ServiceResponse<>(null,false,"no data found",404);
    }

    @PostMapping("createuser")
    public ServiceResponse<String> createUser(@Valid @RequestBody SignupDto data){
        String response=null;
        if(data!=null) {
            response = _userService.addUser(data);
        }
        if(response!=null)
            return new ServiceResponse<>(null,response);
        else
            return new ServiceResponse<>(null,false,"something went wrong",400);
    }
    @PutMapping("updateuser")
    public ServiceResponse<UserDto> updateUser(@Valid @RequestBody UserDto data){
        UserDto response = _userService.updateUser(data);
        return null;
    }
}
