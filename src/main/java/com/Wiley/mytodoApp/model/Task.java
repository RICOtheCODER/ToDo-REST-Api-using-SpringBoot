package com.Wiley.mytodoApp.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="task_id")
    private int taskID;

    @Column(name = "task_detail")
    private String taskDetail;

    @Column(name = "user_id")
    private int userID;

    public Task(String taskDetail, int userID) {
        this.taskDetail = taskDetail;
        this.userID = userID;
    }
}
