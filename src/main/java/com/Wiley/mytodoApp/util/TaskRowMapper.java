package com.Wiley.mytodoApp.util;

import com.Wiley.mytodoApp.model.Task;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TaskRowMapper implements RowMapper<Task> {
    @Override
    public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
        Task task=new Task();
        task.setTaskID(rs.getInt("task_id"));
        task.setTaskDetail(rs.getString("task_detail"));
        task.setUserID(rs.getInt("user_id"));
        return task;
    }
}
