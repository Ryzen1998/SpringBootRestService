package com.blueLine.java.webServices.blueline.spingService.common.user.validation;

import com.blueLine.java.webServices.blueline.spingService.common.user.dto.UserDto;
import com.blueLine.java.webServices.blueline.spingService.common.user.model.User;

public  class Validator {
 public static class userValidator{
      public static boolean isSameAccount(User user, UserDto dto){
         if(user!=null && dto!=null){
             if(user.getId()==dto.getId() && user.getUserName().compareTo(dto.getUserName())==0){
                 return true;
             }
         }
          return false;
      }
  }
}
