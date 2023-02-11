package com.blueLine.java.webServices.blueline.spingService.commons.user.controller;

import com.blueLine.java.webServices.blueline.spingService.commons.user.dto.SignupDto;
import com.blueLine.java.webServices.blueline.spingService.commons.user.dto.UserDto;
import com.blueLine.java.webServices.blueline.spingService.commons.user.service.iUserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> response = _userService.getAllUsers();
        if(!response.isEmpty())
            return new ResponseEntity<List<UserDto>>(response, HttpStatus.OK);
        else
            return new ResponseEntity<List<UserDto>>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("createuser")
    public ResponseEntity<String> createUser(@Valid @RequestBody SignupDto data){
        String response=null;
        if(data!=null) {
            response = _userService.addUser(data);
        }
        if(response!=null)
            return new ResponseEntity<String>(response, HttpStatus.OK);
        else
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
    }
}
