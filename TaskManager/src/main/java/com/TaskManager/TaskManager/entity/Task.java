package com.TaskManager.TaskManager.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Data
@Table(name = "tasks")
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private Status status;

    @DateTimeFormat(pattern="dd-mm-yyyy")
    private Date task_creation_date;

    @DateTimeFormat(pattern="dd-mm-yyyy")
    private Date task_completion_date;

    @DateTimeFormat(pattern="dd-MM-yyyy HH:mm:ss")
    private Date last_updated_at;

    private String priority;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;
}

