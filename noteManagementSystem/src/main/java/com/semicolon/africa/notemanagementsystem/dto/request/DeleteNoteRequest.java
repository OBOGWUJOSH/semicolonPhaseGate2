package com.semicolon.africa.notemanagementsystem.dto.request;

import com.semicolon.africa.notemanagementsystem.utilities.DeleteNoteQuestions;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DeleteNoteRequest {
    private String id;
    private String title;
    private List<DeleteNoteQuestions> deleteNoteQuestionsList;
}
