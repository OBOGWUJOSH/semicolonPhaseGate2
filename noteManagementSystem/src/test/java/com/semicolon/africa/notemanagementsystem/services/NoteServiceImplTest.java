package com.semicolon.africa.notemanagementsystem.services;

import com.semicolon.africa.notemanagementsystem.data.models.Note;
import com.semicolon.africa.notemanagementsystem.dto.request.CreateNoteRequest;
import com.semicolon.africa.notemanagementsystem.dto.response.RegisterUserResponse;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@RequiredArgsConstructor
class NoteServiceImplTest {
    @Autowired
    private NoteService noteService;
    @Test
    public void testThatUserCanAddNotes() {
        CreateNoteRequest userNoteRequest = new CreateNoteRequest();
        userNoteRequest.setTitle("my Book Of Bible Stories");
        userNoteRequest.setContent("this is a sign that this post saves and works");
        assertThat(userNoteRequest).isNotNull();
    }

}