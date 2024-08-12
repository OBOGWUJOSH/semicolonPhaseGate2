package com.semicolon.africa.utilities;


import com.semicolon.africa.data.models.User;
import com.semicolon.africa.data.repositories.TaskRepository;
import com.semicolon.africa.data.repositories.UserRepository;
import com.semicolon.africa.dtos.request.AddTaskRequest;
import com.semicolon.africa.dtos.request.RegisterUserRequest;
import com.semicolon.africa.dtos.request.ShareTaskRequest;
import com.semicolon.africa.dtos.request.TaskUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Validators {
    private  static UserRepository userRepositories;
    private static TaskRepository taskRepository;

    @Autowired
    public Validators(UserRepository userRepository, TaskRepository task) {
        userRepositories = userRepository;
        taskRepository = task;
    }
    public static boolean isEmptyOrNullString(String str) {
        return str == null || str.isEmpty() || str.isBlank();
    }


    public static boolean isUserRegistered(String username) {
        return userRepositories.existsByUsername(username);
    }


    public static boolean isUserLoggedIn(String username) {
        String lowerCaseUsername = username.toLowerCase();
        User user = userRepositories.findByUsername(lowerCaseUsername);
        return !user.isLoggedIn();
    }

    public static  void registeredUserValidation(RegisterUserRequest registerUserRequest) {
        if (isUserRegistered(registerUserRequest.getFirstName()) && isUserRegistered(registerUserRequest.getLastName())) {
            throw new AddUserException("User Already Registered");
        }
        if (isEmptyOrNullString(registerUserRequest.getFirstName()) && isEmptyOrNullString(registerUserRequest.getLastName())) {
            throw new AddUserException("User request cannot be empty, null, or blank");
        }
    }


    public static void addTodoValidation(AddTaskRequest addTaskRequest) {
        if(!isUserRegistered(addTaskRequest.getUsername())){
            throw new TodoAppException("User not registered");
        }
        if(isUserLoggedIn(addTaskRequest.getUsername())){
            throw new TodoAppException("User not logged in");
        }
        if (isEmptyOrNullString(addTaskRequest.getUsername())) {
            throw new TodoAppException("task request cannot be empty, null, or blank");
        }
        if (taskRepository.existsByTitleAndUsername(addTaskRequest.getTitle(), addTaskRequest.getUsername())){
            throw new TodoAppException(" Title already exists");
        }
    }


    public static void updatedTaskValidation(TaskUpdateRequest taskUpdateRequest) {
        if (isEmptyOrNullString(taskUpdateRequest.getTitle())) {
            throw new TodoAppException("task request cannot be empty, null, or blank");
        }
    }

    public static void shareTaskValidation(ShareTaskRequest shareTaskRequest) {
        if(!isUserRegistered(shareTaskRequest.getSender())){
            throw new TodoAppException("User not registered");
        }
        if(isUserLoggedIn(shareTaskRequest.getSender())){
            throw new TodoAppException("User not logged in");
        }
}


}

