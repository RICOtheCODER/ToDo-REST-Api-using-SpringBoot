package com.Wiley.mytodoApp.repository;

import com.Wiley.mytodoApp.model.Task;
import com.Wiley.mytodoApp.util.TaskRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskRepositoryJDBCImpls implements TaskRepository{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TaskRepositoryJDBCImpls(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Task> userTasks(int id) {
        List<Task> taskList=jdbcTemplate.query("select task_id,task_detail,user_id from task where user_id='"+id+"'",
                new TaskRowMapper());
        return taskList;
    }
}
