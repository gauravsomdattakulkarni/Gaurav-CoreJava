package com.TaskManager.TaskManager.service;

import com.TaskManager.TaskManager.entity.Status;
import com.TaskManager.TaskManager.entity.Task;
import com.TaskManager.TaskManager.entity.Users;
import com.TaskManager.TaskManager.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    TaskRepo taskRepo;

    public boolean addTask(Task task, Users user) {  // Pass user explicitly
        try {
            task.setUser(user);  // Ensure the user is set
            Task savedTask = taskRepo.save(task);  // Save the task and get the saved instance
            return savedTask != null && savedTask.getId() != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Task> getAllTasks(Users user) {
        return taskRepo.findByUser(user);
    }

    public void deleteTask(int taskId) {
        taskRepo.deleteById(taskId);
    }

    public boolean updateTaskStatus(int taskId, String taskStatus) {
        Optional<Task> taskDetails = taskRepo.findById(taskId);
        if(taskDetails.isPresent()){
            Task task = taskDetails.get();
            task.setStatus(Status.valueOf(taskStatus));
            taskRepo.save(task);
            return true;
        }else {
            return false;
        }
    }

    public Optional<Task> getTaskById(int id) {
        return taskRepo.findById(id);
    }

    public boolean updateTask(Task existingTask) {
        try {
            taskRepo.save(existingTask);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public long countTasksByStatusAndUser(Status status, Users user) {
        return taskRepo.countByStatusAndUser(status, user);
    }

}
