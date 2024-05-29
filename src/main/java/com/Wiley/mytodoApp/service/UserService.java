package com.Wiley.mytodoApp.service;

import com.Wiley.mytodoApp.dto.UserDto;
import com.Wiley.mytodoApp.model.User;

import java.util.List;

public interface UserService {

    public UserDto saveUser(UserDto userDto);

    public UserDto getUserByID(int id);

   public UserDto getUserByName(String firstname,String lastname);

   public UserDto getUserByPhoneNo(String phoneno);

   public void deleteUser(int id);

   public List<UserDto> getAlluser();

   public UserDto updateUser(int id,UserDto user);
}
