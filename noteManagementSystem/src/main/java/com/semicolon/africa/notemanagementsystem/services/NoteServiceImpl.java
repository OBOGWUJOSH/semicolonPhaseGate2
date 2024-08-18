package com.semicolon.africa.notemanagementsystem.services;

import com.semicolon.africa.notemanagementsystem.data.models.Note;
import com.semicolon.africa.notemanagementsystem.data.repositories.NoteRepository;
import com.semicolon.africa.notemanagementsystem.data.repositories.UserRepository;
import com.semicolon.africa.notemanagementsystem.dto.request.CreateNoteRequest;
import com.semicolon.africa.notemanagementsystem.dto.request.DeleteNoteRequest;
import com.semicolon.africa.notemanagementsystem.dto.request.UpdateNoteRequest;
import com.semicolon.africa.notemanagementsystem.dto.response.CreateNoteResponse;
import com.semicolon.africa.notemanagementsystem.dto.response.DeleteNoteResponse;
import com.semicolon.africa.notemanagementsystem.dto.response.RegisterUserResponse;
import com.semicolon.africa.notemanagementsystem.dto.response.UpdateNoteResponse;
import com.semicolon.africa.notemanagementsystem.utilities.NoteManagementException;
import com.semicolon.africa.notemanagementsystem.utilities.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class NoteServiceImpl implements NoteService{
    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @Override
    public CreateNoteResponse createNote(CreateNoteRequest request) {
        CreateNoteRequest createNoteRequest = new CreateNoteRequest();
        Note note = new Note();
        note.setTitle(createNoteRequest.getTitle());
        note.setContent(createNoteRequest.getContent());
        note.setId(createNoteRequest.getId());
        note.setDateCreated(LocalDateTime.now());
        note.setTaskStatus(note.isTaskStatus());
        noteRepository.save(note);
        CreateNoteResponse createNoteResponse = new CreateNoteResponse();
        createNoteResponse.setMessage("new note created THANK YOU!!!");
        return createNoteResponse;
    }

    @Override
    public DeleteNoteResponse deleteNoteByTitle(DeleteNoteRequest delRequest) {
        Note note = findNoteByTitle(delRequest.getTitle());
        noteRepository.delete(note);
        throw new NoteManagementException("user name dose not exist");
    }

    private Note findNoteByTitle(String title) {
        return noteRepository.findNoteByTitle(title);

    }

    @Override
    public UpdateNoteResponse updateNote(UpdateNoteRequest updateNote) {
        Note updateThisNote = findNoteByTitle(updateNote.getNoteTitle());
        if (updateThisNote != null) {
            updateNote.setNoteTitle(updateNote.getNoteTitle());
            updateNote.setContent(updateNote.getContent());
            updateNote.setDateUpdated(updateNote.getDateUpdated());
            updateNote.setTaskStatus(updateNote.getTaskStatus());
            noteRepository.save(updateThisNote);
        }
        throw new RuntimeException("note name dose not exist");
    }



}
