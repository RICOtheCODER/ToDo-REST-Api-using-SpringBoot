package com.Wiley.mytodoApp.service;

import com.Wiley.mytodoApp.dto.UserDto;
import com.Wiley.mytodoApp.model.User;
import com.Wiley.mytodoApp.repository.UserRepository;
import com.Wiley.mytodoApp.util.EntityDtoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDto saveUser(UserDto userDto) {
        User user=repository.saveUser(EntityDtoUtil.convertToUserEntity(userDto));
        return EntityDtoUtil.convertToUserDto(user);
    }

    @Override
    public UserDto getUserByID(int id) {
        return repository.getUserById(id).map(EntityDtoUtil::convertToUserDto).orElse(null);
    }

    @Override
    public UserDto getUserByName(String firstname, String lastname) {
        return repository.getUserByName(firstname,lastname).map(EntityDtoUtil::convertToUserDto).orElse(null);
    }

    @Override
    public UserDto getUserByPhoneNo(String phoneno) {
        return repository.getUserByPhoneNo(phoneno).map(EntityDtoUtil::convertToUserDto).orElse(null);
    }

    @Override
    public void deleteUser(int id) {
        repository.deleteUser(id);
    }

    @Override
    public List<UserDto> getAlluser() {
        return repository.getAllUser().parallelStream().map(EntityDtoUtil::convertToUserDto).toList();
    }

    @Override
    public UserDto updateUser(int id, UserDto user) {
        User user1=repository.updateUser(id,EntityDtoUtil.convertToUserEntity(user));
        return EntityDtoUtil.convertToUserDto(user1);
    }
}
