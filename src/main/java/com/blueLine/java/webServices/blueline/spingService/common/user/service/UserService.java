package com.blueLine.java.webServices.blueline.spingService.common.user.service;

import com.blueLine.java.webServices.blueline.spingService.common.serviceResponse.ServiceResponse;
import com.blueLine.java.webServices.blueline.spingService.common.user.dto.SignupDto;
import com.blueLine.java.webServices.blueline.spingService.common.user.dto.UserDto;
import com.blueLine.java.webServices.blueline.spingService.common.user.enums.FilterUserBy;
import com.blueLine.java.webServices.blueline.spingService.common.user.model.User;
import com.blueLine.java.webServices.blueline.spingService.common.user.objCast.CastUserObj;
import com.blueLine.java.webServices.blueline.spingService.common.user.repository.UserRepository;
import com.blueLine.java.webServices.blueline.spingService.common.user.validation.Validator;
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
    public ServiceResponse<List<UserDto>> getAllUsers() {
        List<User> userList = userRepository.getAllUsers();
        if(userList!=null){
            return new ServiceResponse<>(castUserObj.userListToUserDTOList(userList),"Success");
        }
        return new ServiceResponse<>(null,false,"No Data Found",404);
    }

    @Override
    public ServiceResponse<String> addUser(SignupDto data) {
        if(data!=null){
            if(userRepository.findUserBy(FilterUserBy.user_name,data.getUserName())!=null){
                return new ServiceResponse<>(null,false,"Username is Taken",406);
            } else if(userRepository.findUserBy(FilterUserBy.email,data.getEmail())!=null){
                return new ServiceResponse<>(null,false,"Email Already in Use",406);
            } else if(userRepository.findUserBy(FilterUserBy.phone_number,data.getPhoneNumber())!=null){
                return new ServiceResponse<>(null,false,"Phone Number Already Exists",406);
            }else {
                userRepository.addNewUser(data);
                return new ServiceResponse<>(null,true,String.format("Welcome %s",data.getUserName()),201);
            }
        }
        return new ServiceResponse<>(null,false,"oops! Something Went Wrong",500);
    }

    @Override
    public ServiceResponse<UserDto> updateUser(UserDto data) {
        if(data!=null && Validator.userValidator.isSameAccount(userRepository.getUserById(data.getId()),data))
        {
            if(userRepository.findUserBy(FilterUserBy.email,data.getEmail())!=null){
                return new ServiceResponse<>(null,false,"Email Already in Use",406);
            } else if(userRepository.findUserBy(FilterUserBy.phone_number,data.getPhoneNumber())!=null) {
                return new ServiceResponse<>(null, false, "Phone Number Already Exists", 406);
            }else {
                User response = userRepository.updateUser(castUserObj.userDtoToUser(data));
                 return new ServiceResponse<>(castUserObj.userToUserDto(response),"Success");
            }
        }
        return new ServiceResponse<>(null,false,"oops! No Matching Data Found",404);
    }

    @Override
    public ServiceResponse<Boolean> removeUser(Long id) {
        if(userRepository.getUserById(id)!=null){
            boolean response = userRepository.removeUserById(id);
            if (response){
                return new ServiceResponse<>(true,"User Removed");
            }
            else {
                return new ServiceResponse<>(false,false,"Something Went Wrong",500);
            }
        }
        return new ServiceResponse<>(false,false,"User Not Found",404);
    }

    @Override
    public ServiceResponse<User> findUserBy(FilterUserBy filterUserBy, String searchParameter) {
        if(searchParameter!=null){
            User result = userRepository.findUserBy(filterUserBy,searchParameter);
            if(result!=null){
                return  new ServiceResponse<>(result,"Success");
            }
        }
        return new ServiceResponse<>(null,false,"User Not Found",404);
    }
}
