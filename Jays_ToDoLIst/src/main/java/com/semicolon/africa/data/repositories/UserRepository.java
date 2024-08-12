package com.semicolon.africa.data.repositories;

import com.semicolon.africa.data.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    boolean existsByUsername(String username);
    User findByUsername(String Id);

}