package com.Wiley.mytodoApp.service;

import com.Wiley.mytodoApp.dto.TaskDto;

import java.util.List;

public interface TaskService {
    public List<TaskDto> viewAllTasksByUserID(int id);
}
