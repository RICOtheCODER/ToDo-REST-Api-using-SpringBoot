package com.Wiley.mytodoApp.model;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Task {

    private int taskID;
    private String taskDetail;
    private int userID;

    public Task(String taskDetail, int userID) {
        this.taskDetail = taskDetail;
        this.userID = userID;
    }
}
