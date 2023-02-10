package com.blueLine.java.webServices.blueline.spingService.commons.user.objCast;

import com.blueLine.java.webServices.blueline.spingService.commons.user.dto.UserDto;
import com.blueLine.java.webServices.blueline.spingService.commons.user.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CastUserObj {

    public List<UserDto> userObjectConversion(List<User> users){
        if(users!=null){
             List<UserDto> userList = new ArrayList<>();
             users.stream().forEach(x->
                     userList.add(
                             new UserDto(
                                     x.getId(),
                                     x.getName(),
                                     x.getEmail(),
                                     x.getUserName(),
                                     x.getPhoneNumber(),
                                     x.isActive()
                             )
                     ));
             return userList;
        }
      return null;
    }
    public List<User> userObjectConversion(UserDto user){

        return null;
    }
}
