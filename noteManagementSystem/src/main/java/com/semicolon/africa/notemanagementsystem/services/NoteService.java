package com.semicolon.africa.notemanagementsystem.services;

import com.semicolon.africa.notemanagementsystem.dto.request.CreateNoteRequest;
import com.semicolon.africa.notemanagementsystem.dto.response.CreateNoteResponse;

public interface NoteService  {
    CreateNoteResponse createNoteWith (CreateNoteRequest request);


}