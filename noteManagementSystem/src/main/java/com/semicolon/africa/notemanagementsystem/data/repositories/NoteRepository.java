package com.semicolon.africa.notemanagementsystem.data.repositories;

import com.semicolon.africa.notemanagementsystem.data.models.Note;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends MongoRepository<Note,String> {

}
