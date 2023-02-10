package com.blueLine.java.webServices.blueline.spingService.commons.user.controller;

import com.blueLine.java.webServices.blueline.spingService.commons.user.dto.UserDto;
import com.blueLine.java.webServices.blueline.spingService.commons.user.service.iUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<List<UserDto>> GetAllUsers(){
        List<UserDto> response = _userService.GetAllUsers();
        if(!response.isEmpty())
            return new ResponseEntity<List<UserDto>>(response, HttpStatus.OK);
        else
            return new ResponseEntity<List<UserDto>>(HttpStatus.NOT_FOUND);
    }
}
