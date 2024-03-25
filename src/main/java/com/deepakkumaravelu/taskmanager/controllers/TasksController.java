package com.deepakkumaravelu.taskmanager.controllers;

import com.deepakkumaravelu.taskmanager.dtos.CreateTaskDTO;
import com.deepakkumaravelu.taskmanager.entities.TaskEntity;
import com.deepakkumaravelu.taskmanager.services.TaskServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TasksController {
    private final TaskServices taskServices;

    public TasksController(TaskServices taskServices){
        this.taskServices=taskServices;
    }
    @GetMapping("/")
    public ResponseEntity<List<TaskEntity>> getTasks(){
     var tasks=taskServices.getTasks();
     return ResponseEntity.ok(tasks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskEntity>getTaskById(@PathVariable("id") Integer id){
        var task=taskServices.getTaskById(id);
        if(task==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(task);
    }

    @PostMapping("/")
    public ResponseEntity<TaskEntity>addTask(@RequestBody CreateTaskDTO body) throws ParseException {
     var task=taskServices.addTask(body.getTitle(),body.getDescription(),body.getDeadline());

     return ResponseEntity.ok(task);
    }
}
