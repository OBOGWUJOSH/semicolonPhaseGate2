package com.semicolon.africa.notemanagementsystem.data.repositories;

import com.semicolon.africa.notemanagementsystem.data.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,String>{

}
