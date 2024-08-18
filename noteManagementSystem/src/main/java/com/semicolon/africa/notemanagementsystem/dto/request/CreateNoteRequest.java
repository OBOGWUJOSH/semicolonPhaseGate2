package com.semicolon.africa.notemanagementsystem.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CreateNoteRequest {
    private String id;//generated by ide
    private String title;
    private String content;
    private LocalDateTime dateCreated;

}
