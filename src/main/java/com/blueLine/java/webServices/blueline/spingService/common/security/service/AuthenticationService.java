package com.blueLine.java.webServices.blueline.spingService.common.security.service;

import com.blueLine.java.webServices.blueline.spingService.common.security.model.LoginRequest;
import com.blueLine.java.webServices.blueline.spingService.common.serviceResponse.ServiceResponse;
import com.blueLine.java.webServices.blueline.spingService.common.user.dto.SignupDto;
import com.blueLine.java.webServices.blueline.spingService.common.user.enums.FilterUserBy;
import com.blueLine.java.webServices.blueline.spingService.common.user.model.User;
import com.blueLine.java.webServices.blueline.spingService.common.user.mapper.MapUserObject;
import com.blueLine.java.webServices.blueline.spingService.common.user.service.userService.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final MapUserObject mapUserObject;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UserService userService, PasswordEncoder passwordEncoder, JwtService jwtService, MapUserObject mapUserObject, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.mapUserObject = mapUserObject;
        this.authenticationManager = authenticationManager;
    }

    public ServiceResponse<String> authenticate(LoginRequest request) {
         try{
             authenticationManager.authenticate(
                     new UsernamePasswordAuthenticationToken(
                             request.getEmail(),
                             request.getPassword()
                     )
             );
             ServiceResponse<User> user = userService.findUserBy(FilterUserBy.email,request.getEmail());
             if(user.getResultData()!=null){
                 String jwtToken = jwtService.generateToken(user.getResultData());
                 return new ServiceResponse<>(jwtToken,String.format("Welcome Back %s",
                         user.getResultData().getUserName()));
             }
         }catch(Exception ex){
             return new ServiceResponse<>(null,false,"Invalid Username or Password",404);
         }
        return new ServiceResponse<>(null,false,"Invalid Credentials",404);
    }

    public ServiceResponse<String> register(SignupDto request) {
        if(request!=null) {
            SignupDto dto = new SignupDto(
                    request.getName(),
                    request.getEmail().toLowerCase().replace(" ", ""),
                    request.getUserName(),
                    request.getPhoneNumber(),
                    passwordEncoder.encode(request.getPassword())
            );
            ServiceResponse<String> result = userService.addUser(dto);
            if (result.isSuccess()) {
                String jwtToken = jwtService.generateToken(mapUserObject.signupDtoToUser(dto));
                return new ServiceResponse<>(jwtToken, "Success");
            }
            else {
                return new ServiceResponse<>(null,false, result.getMessage(), 400);
            }
        }
        return new ServiceResponse<>(null,false,"Unable to Register User",500);
    }
}
