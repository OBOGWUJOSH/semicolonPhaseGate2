package com.semicolon.africa.data.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Document
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Task {
    @Id
    private String id;
    private String title;
    private String description;
    private LocalDateTime dateTimeCreated = LocalDateTime.now();
    private LocalDateTime dateTimeUpdated = LocalDateTime.now();
    private LocalDate dueDate;
    private TaskStatus status;
    private TaskPriority priority;
//    private String sender;
//    private String receiver;
//    private String email;

}
