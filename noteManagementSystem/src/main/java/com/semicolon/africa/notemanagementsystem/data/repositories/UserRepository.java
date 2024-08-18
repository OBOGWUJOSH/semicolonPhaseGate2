package com.semicolon.africa.notemanagementsystem.data.repositories;

import com.semicolon.africa.notemanagementsystem.data.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
    boolean existsByUserNameOrEmail(String userName, String Email);

    void findByUserName(String userName);

    List<User> findAllByUserName(String userName);

    User findUserByPassword(String password);

    User findUsersById(String id);

    void deleteByUserName(String user);

}


 