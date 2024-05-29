package com.Wiley.mytodoApp.util;

import com.Wiley.mytodoApp.dto.UserDto;
import com.Wiley.mytodoApp.model.User;

public class EntityDtoUtil {

    //2 methods ---- >

    public static User convertToUserEntity(UserDto userDto){
        return new User(userDto.firstname(), userDto.lastname(), userDto.email(), userDto.contact());
    }

    public static UserDto convertToUserDto(User user){
        return new UserDto(user.getUid(), user.getFirstname(),user.getLastname(), user.getEmail(), user.getContact());
    }
}
