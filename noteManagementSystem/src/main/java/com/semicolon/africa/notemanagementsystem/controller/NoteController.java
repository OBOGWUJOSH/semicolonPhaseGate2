package com.semicolon.africa.notemanagementsystem.controller;

import com.semicolon.africa.notemanagementsystem.services.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class NoteController {
    @Autowired
    private NoteService noteService;


//    @PostMapping

















}
