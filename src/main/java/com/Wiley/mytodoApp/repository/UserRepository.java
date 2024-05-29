package com.Wiley.mytodoApp.repository;

import com.Wiley.mytodoApp.model.Task;
import com.Wiley.mytodoApp.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    public User saveUser(User user);

    public Optional<User> getUserById(int id);

    public Optional<User> getUserByName(String firstname,String lastname);

    public Optional<User> getUserByPhoneNo(String phoneNo);

    public void deleteUser(int id);

    public List<User>getAllUser();

    public User updateUser(int id,User user);


}
