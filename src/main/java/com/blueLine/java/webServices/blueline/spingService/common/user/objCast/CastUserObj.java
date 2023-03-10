package com.blueLine.java.webServices.blueline.spingService.common.user.objCast;

import com.blueLine.java.webServices.blueline.spingService.common.user.dto.UserDto;
import com.blueLine.java.webServices.blueline.spingService.common.user.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CastUserObj {

    public List<UserDto> userListToUserDTOList(List<User> users){
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
                                     x.isActive(),
                                     Integer.toString(x.getRole())
                             )
                     ));
             return userList;
        }
      return null;
    }
    public User UserDtoToUser(UserDto userDto){
        if(userDto!=null){
            User result = new User(userDto.getEmail(), userDto.getName(),userDto.getPhoneNumber(),userDto.getId());
            return  result;
        }
        return null;
    }

    public UserDto userToUserDto(User user){
        if(user!=null) {
            UserDto dto = new UserDto(
                    user.getId(),
                    user.getName(),
                    user.getEmail(),
                    user.getUserName(),
                    user.getPhoneNumber(),
                    user.isActive(),
                    Integer.toString(user.getRole())
            );
            return dto;
        }
        return null;
    }
}
