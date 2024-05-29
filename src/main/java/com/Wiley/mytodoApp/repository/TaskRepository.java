package com.Wiley.mytodoApp.repository;

import com.Wiley.mytodoApp.model.Task;

import java.util.List;

public interface TaskRepository {
    public List<Task> userTasks(int id);
}
