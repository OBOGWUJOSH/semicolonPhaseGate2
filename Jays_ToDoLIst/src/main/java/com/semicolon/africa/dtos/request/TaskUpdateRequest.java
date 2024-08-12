package com.semicolon.africa.dtos.request;


import com.semicolon.africa.data.models.TaskPriority;
import com.semicolon.africa.data.models.TaskStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter

public class TaskUpdateRequest {
    private String username;
    private String title;
    private String newTitle;
    private String description;
    private TaskStatus status;
    private TaskPriority priority;
    private LocalDate dueDate;

}

