package com.Wiley.mytodoApp.repository;

import com.Wiley.mytodoApp.exception.UserNotFoundException;
import com.Wiley.mytodoApp.model.Task;
import com.Wiley.mytodoApp.model.User;
import com.Wiley.mytodoApp.util.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryJDBCImpls implements UserRepository{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepositoryJDBCImpls(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User saveUser(User user) {
        int rowCount=jdbcTemplate.update("insert into user(user_firstname,user_lastname,user_email,user_contact) values\n" +
                "(?,?,?,?)",user.getFirstname(),user.getLastname(),user.getEmail(),user.getContact());
        if(rowCount >0){
            return getUserByName(user.getFirstname(), user.getLastname()).get();
        }
        return null;
    }

    @Override
    public Optional<User> getUserById(int id) {
        try {
            User user = jdbcTemplate.queryForObject("select * from user where user_id='" + id + "'",
                    new UserRowMapper());
            if (user == null) {
                throw new UserNotFoundException("User with id " + id + " does not exist");
            }
            return Optional.of(user);
        }catch (DataAccessException exception){
            throw new UserNotFoundException("User with the given ID does not exist");
        }
    }

    @Override
    public Optional<User> getUserByName(String firstname,String lastname) {
        try {
            User user = jdbcTemplate.queryForObject("select user_id,user_firstname,user_lastname,user_email,user_contact from user where user_firstname = '" + firstname + "'" +
                    " and user_lastname='" + lastname + "'", new UserRowMapper());
            if (user == null) {
                throw new UserNotFoundException("User with name "+firstname+" "+lastname+" not Found");
            }
            return Optional.of(user);

        }catch (DataAccessException exception){
            throw new UserNotFoundException("User with name "+firstname+" "+lastname+" not present");
        }
    }

    @Override
    public Optional<User> getUserByPhoneNo(String phoneNo) {
        try {
            User user = jdbcTemplate.queryForObject("select user_id,user_firstname,user_lastname,user_email,user_contact from user where user_contact='" + phoneNo+"'",
                    new UserRowMapper());
            if (user == null) {
                throw new UserNotFoundException("User with Phone Number " + phoneNo + " not Found");
            }
            return Optional.of(user);
        }catch (DataAccessException e){
            throw  new UserNotFoundException("User with phone number "+phoneNo+" does not exist");
        }

    }

    @Override
    public void deleteUser(int id) {
        Optional<User> user=getUserById(id);
        System.out.println(user);
        if(user.isPresent()){
            jdbcTemplate.update("delete from user where user_id=?",id);
        }
        else {
            throw new UserNotFoundException("The User with the given ID does not exist");
        }
    }

    @Override
    public List<User> getAllUser() {
        List<User> userList=jdbcTemplate.query("select user_id,user_firstname,user_lastname,user_email,user_contact from user",
                new UserRowMapper() );
        return userList;

    }

    @Override
    public User updateUser(int id, User user) {
       int rowCount=jdbcTemplate.update("update user set user_firstname=?,user_lastname=?,user_email=?,user_contact=?\n" +
               "where user_id=?",user.getFirstname(),user.getLastname(),user.getEmail(),user.getContact(),id);
       if(rowCount==0){
           throw new UserNotFoundException("user with id "+id+" not found");
       }
       User updatedUser=getUserById(id).get();
       return updatedUser;
    }


}
