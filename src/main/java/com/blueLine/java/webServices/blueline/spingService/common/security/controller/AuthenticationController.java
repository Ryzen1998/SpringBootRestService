package com.blueLine.java.webServices.blueline.spingService.common.security.controller;

import com.blueLine.java.webServices.blueline.spingService.common.security.model.LoginRequest;
import com.blueLine.java.webServices.blueline.spingService.common.security.service.AuthenticationService;
import com.blueLine.java.webServices.blueline.spingService.common.serviceResponse.ServiceResponse;
import com.blueLine.java.webServices.blueline.spingService.common.user.dto.SignupDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/auth")
public class AuthenticationController {
   private final AuthenticationService authenticationService;
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }
    @PostMapping("register")
    public ServiceResponse<String> register(@RequestBody SignupDto request){
        ServiceResponse<String> response = authenticationService.register(request);
        return response;
    }
    @PostMapping("login")
    public ServiceResponse<String> login(@RequestBody LoginRequest request){
        ServiceResponse<String> response = authenticationService.authenticate(request);
        return response;
    }

}
