package com.semicolon.africa.notemanagementsystem.data.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document


public class User {
    private String id;
    private String userName;
    private String email;
    private String PhoneNumber;
    private String password;
    private List<Note> lists;

}
