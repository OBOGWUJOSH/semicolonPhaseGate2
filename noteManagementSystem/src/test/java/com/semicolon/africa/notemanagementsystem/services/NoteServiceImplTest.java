package com.semicolon.africa.notemanagementsystem.services;

import com.semicolon.africa.notemanagementsystem.data.repositories.NoteRepository;
import com.semicolon.africa.notemanagementsystem.dto.request.CreateNoteRequest;
import com.semicolon.africa.notemanagementsystem.dto.request.UpdateNoteRequest;
import com.semicolon.africa.notemanagementsystem.dto.response.CreateNoteResponse;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@RequiredArgsConstructor
//@Transactional
class NoteServiceImplTest{
    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    private NoteService noteService;



    @Test
    public void testThatUserCanAddNotes() {
        CreateNoteRequest userNoteRequest = new CreateNoteRequest();
        userNoteRequest.setTitle("my Book Of Bible Stories");
        userNoteRequest.setContent("this is a sign that this post saves and works");
        assertThat(userNoteRequest).isNotNull();
    }

    @Test
    public void testThatUserCanDeleteNote(){
        CreateNoteRequest createNoteRequest1 = new CreateNoteRequest();
        createNoteRequest1.setTitle("my Book Of Bible Stories");
        createNoteRequest1.setContent("this is juts a note for the note_less");
        createNoteRequest1.setDateCreated(LocalDateTime.now());
        CreateNoteResponse createNoteResponse = new CreateNoteResponse();
        noteService.createNote(createNoteRequest1);
        assertThat(createNoteResponse).isNotNull();
        assertThat(noteRepository.count()).isEqualTo(1);


//        CreateNoteRequest createNoteRequest1 = new CreateNoteRequest();
        createNoteRequest1.setTitle("most babes are wicked");
        createNoteRequest1.setContent("omo this babe wan kill person na why i de do like this some times");
        createNoteRequest1.setDateCreated(LocalDateTime.now());
        CreateNoteResponse createNoteResponse2 = new CreateNoteResponse();
        noteService.createNote(createNoteRequest1);
        assertThat(createNoteResponse2).isNotNull();
        assertThat(noteRepository.count()).isEqualTo(2);

        noteRepository.deleteNotesByTitle("most babes are wicked");
        assertThat(noteRepository.count()).isEqualTo(1);

    }

    @Test
    public void testThatNoteAddedCanBeUpdated(){
        CreateNoteRequest createNoteRequest1 = new CreateNoteRequest();
        createNoteRequest1.setTitle("my Book Of Bible Stories");
        createNoteRequest1.setContent("this is juts a note for the note_less");
        createNoteRequest1.setDateCreated(LocalDateTime.now());
        CreateNoteResponse createNoteResponse = new CreateNoteResponse();
        noteService.createNote(createNoteRequest1);
        assertThat(createNoteResponse).isNotNull();
        assertThat(noteRepository.count()).isEqualTo(1);


        createNoteRequest1.setTitle("most babes are wicked");
        createNoteRequest1.setContent("omo this babe wan kill person na why i de do like this some times");
        createNoteRequest1.setDateCreated(LocalDateTime.now());
        CreateNoteResponse createNoteResponse2 = new CreateNoteResponse();
        noteService.createNote(createNoteRequest1);
        assertThat(createNoteResponse2).isNotNull();
        assertThat(noteRepository.count()).isEqualTo(2);

        UpdateNoteRequest updateNoteRequest = new UpdateNoteRequest();
        updateNoteRequest.setNoteTitle("most babes are wicked");
        updateNoteRequest.setContent("omo this babe wan kill person na why i de do like this some times");
        updateNoteRequest.setTaskStatus(updateNoteRequest.getTaskStatus());




    }



}