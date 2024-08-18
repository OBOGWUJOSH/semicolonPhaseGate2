package com.semicolon.africa.notemanagementsystem.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateNoteRequest {
    private String noteTitle;
    private String content;
    private String taskStatus;
    private String dateUpdated;
}
