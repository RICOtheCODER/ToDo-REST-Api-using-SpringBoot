package com.Wiley.mytodoApp.util;

import com.Wiley.mytodoApp.dto.TaskDto;
import com.Wiley.mytodoApp.model.Task;

public class TaskDtoUtil {
    //2 methods
    public static Task convertToTaskEntity(TaskDto taskDto){
        return new Task(taskDto.taskDetail(),taskDto.userId());
    }

    public static TaskDto convertToTaskDto(Task task){
        return new TaskDto(task.getTaskID(), task.getTaskDetail(),task.getUserID());
    }
}
