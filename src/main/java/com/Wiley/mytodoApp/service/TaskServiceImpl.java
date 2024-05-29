package com.Wiley.mytodoApp.service;

import com.Wiley.mytodoApp.dto.TaskDto;
import com.Wiley.mytodoApp.repository.TaskRepository;
import com.Wiley.mytodoApp.util.TaskDtoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{

    private final TaskRepository repository;

    @Autowired
    public TaskServiceImpl(TaskRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TaskDto> viewAllTasksByUserID(int id) {
        return repository.userTasks(id).parallelStream().map(TaskDtoUtil::convertToTaskDto).toList();
    }
}
