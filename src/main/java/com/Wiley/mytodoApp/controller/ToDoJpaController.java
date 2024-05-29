package com.Wiley.mytodoApp.controller;

import com.Wiley.mytodoApp.dto.TaskDto;
import com.Wiley.mytodoApp.service.TaskJpaService;
import com.Wiley.mytodoApp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/toDo/jpa")
public class ToDoJpaController {

    @Autowired
    private TaskJpaService taskJpaService;

    @GetMapping
    public List<TaskDto> taskDtoList(){
        return taskJpaService.getAllTask();
    }


    @GetMapping("/{id}")
    public TaskDto gettaskById(@PathVariable("id") int id){
        return taskJpaService.getTaskByID(id);
    }

}
