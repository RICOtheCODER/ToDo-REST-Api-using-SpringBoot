package com.Wiley.mytodoApp.service;

import com.Wiley.mytodoApp.dto.TaskDto;

import java.util.List;

public interface TaskJpaService {

    List<TaskDto> getAllTask();

    TaskDto getTaskByID(int id);
}
