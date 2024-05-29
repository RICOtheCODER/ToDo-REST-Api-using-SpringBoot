package com.Wiley.mytodoApp.controller;

import com.Wiley.mytodoApp.dto.TaskDto;
import com.Wiley.mytodoApp.dto.UserDto;
import com.Wiley.mytodoApp.service.TaskService;
import com.Wiley.mytodoApp.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/toDo")
public class ToDoController {

    @Autowired
    UserService userService;

    @Autowired
    TaskService taskService;


    @PostMapping
    public ResponseEntity<UserDto> saveuser(@RequestBody @Valid UserDto userDto){
         UserDto saveUser =userService.saveUser(userDto);
        HttpStatus status;
        if(saveUser!=null){
            status=HttpStatus.CREATED;
        }
        else {
          status=HttpStatus.BAD_REQUEST;
        }
        return ResponseEntity.status(status).body(saveUser);
    }


    @GetMapping("/{firstname}/{lastname}")
    public UserDto getUserByname(@PathVariable("firstname") String firstname,
                                 @PathVariable("lastname") String lastname){
          return userService.getUserByName(firstname,lastname);
    }

    @GetMapping("/{phoneno}")
    public UserDto getUserByPhoneNumber(@PathVariable("phoneno") String phoneno){
        return userService.getUserByPhoneNo(phoneno);
    }

    @GetMapping("/user/{id}")
    public UserDto getUserByID(@PathVariable("id") int id){
        return userService.getUserByID(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserById(@PathVariable("id") int id){
        userService.deleteUser(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto updateUser(@PathVariable("id") int id, @RequestBody @Valid UserDto dto){
        UserDto updated=userService.updateUser(id,dto);
        return updated;
    }

    @GetMapping
    public List<UserDto> getAllUser(){
        return userService.getAlluser();
    }

    @GetMapping("/tasks/{id}")
    public List<TaskDto> getAllTasks(@PathVariable("id") int id){
        return taskService.viewAllTasksByUserID(id);
    }

}
