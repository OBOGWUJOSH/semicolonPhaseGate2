package com.semicolon.africa.data.repositories;

import com.semicolon.africa.data.models.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepository extends MongoRepository<Task, String> {

    boolean existsByTitleAndUsername(String title, String username);
    Optional<Task> findTaskByTitle(String title);
    Task findTaskById(String id);

}
