package com.deepakkumaravelu.taskmanager.services;

import com.deepakkumaravelu.taskmanager.entities.TaskEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;


@Repository
public class TaskServices {
    private ArrayList<TaskEntity> tasks=new ArrayList<>();
    private int taskId=1;

public TaskEntity addTask(String title,String description,String deadline){
    TaskEntity task=new TaskEntity();
    task.setId(taskId);
    task.setDescription(description);
    task.setTitle(title);
    task.setDeadline(new Date(deadline));//validate date format
    task.setCompleted(false);
    tasks.add(task);
    taskId++;
    return task;
}

    public ArrayList<TaskEntity> getTasks() {
        return tasks;
    }

    public TaskEntity getTaskById(int id) {
    for(TaskEntity task:tasks){
        if(task.getId()==id){
            return task;
        }
    }
    return null;
    }
}
