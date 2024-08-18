package com.semicolon.africa.notemanagementsystem.services;

import com.semicolon.africa.notemanagementsystem.dto.request.CreateNoteRequest;
import com.semicolon.africa.notemanagementsystem.dto.request.DeleteNoteRequest;
import com.semicolon.africa.notemanagementsystem.dto.request.UpdateNoteRequest;
import com.semicolon.africa.notemanagementsystem.dto.response.CreateNoteResponse;
import com.semicolon.africa.notemanagementsystem.dto.response.DeleteNoteResponse;
import com.semicolon.africa.notemanagementsystem.dto.response.UpdateNoteResponse;

public interface NoteService  {
    CreateNoteResponse createNote (CreateNoteRequest request);
    DeleteNoteResponse deleteNoteByTitle (DeleteNoteRequest delRequest);
    UpdateNoteResponse updateNote (UpdateNoteRequest updateNoteRequest);



}