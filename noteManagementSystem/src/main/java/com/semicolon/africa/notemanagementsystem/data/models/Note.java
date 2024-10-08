package com.semicolon.africa.notemanagementsystem.data.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Note {
    @Id
    private String id;
    private String title;
    private String content;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;
    private boolean taskStatus;

}
