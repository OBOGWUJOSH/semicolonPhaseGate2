package com.semicolon.africa.dtos.request;


import ch.qos.logback.core.status.Status;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.semicolon.africa.data.models.TaskPriority;
import com.semicolon.africa.data.models.TaskStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class  AddTaskRequest {
    private String title;
    private String description;
    private TaskPriority priority;
    private LocalDate dueDate;
    private String username;
    private TaskStatus taskStatus;
}
