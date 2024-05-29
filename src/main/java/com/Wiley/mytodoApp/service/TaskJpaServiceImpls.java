package com.Wiley.mytodoApp.service;

import com.Wiley.mytodoApp.dto.TaskDto;
import com.Wiley.mytodoApp.repository.TaskJPARepository;
import com.Wiley.mytodoApp.util.TaskDtoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskJpaServiceImpls implements TaskJpaService{


    private final TaskJPARepository taskJPARepository;

    @Autowired
    public TaskJpaServiceImpls(TaskJPARepository taskJPARepository) {
        this.taskJPARepository = taskJPARepository;
    }

    @Override
    public List<TaskDto> getAllTask() {

        return taskJPARepository.findAll().parallelStream().map(TaskDtoUtil::convertToTaskDto).toList();
    }

    @Override
    public TaskDto getTaskByID(int id) {
        return taskJPARepository.findById(id).map(TaskDtoUtil::convertToTaskDto).orElse(null);
    }
}
