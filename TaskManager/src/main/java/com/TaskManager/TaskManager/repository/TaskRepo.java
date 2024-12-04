package com.TaskManager.TaskManager.repository;

import com.TaskManager.TaskManager.entity.Status;
import com.TaskManager.TaskManager.entity.Task;
import com.TaskManager.TaskManager.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepo extends JpaRepository<Task,Integer> {

    List<Task> findByUser(Users user);

    long countByStatusAndUser(Status status, Users user);
}
