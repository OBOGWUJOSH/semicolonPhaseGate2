package com.semicolon.africa.utilities;


import com.semicolon.africa.data.models.Task;
import com.semicolon.africa.data.models.TaskStatus;
import com.semicolon.africa.data.models.User;
import com.semicolon.africa.dtos.request.AddTaskRequest;
import com.semicolon.africa.dtos.request.RegisterUserRequest;
import com.semicolon.africa.dtos.request.TaskUpdateRequest;
import com.semicolon.africa.dtos.response.DeleteTaskResponse;
import com.semicolon.africa.dtos.response.RegisterUserResponse;
import com.semicolon.africa.dtos.response.ShareTaskResponse;
import com.semicolon.africa.dtos.response.UpdateTaskResponse;

import java.time.LocalDate;



public class Mapper {

    public static User map(RegisterUserRequest registerUserRequest ) {

        User user = new User();
        user.setUsername(registerUserRequest.getFirstName());
        user.setUsername(registerUserRequest.getLastName());
        return user;
    }


    public static RegisterUserResponse map(User user){
        RegisterUserResponse registerUserResponse = new RegisterUserResponse();
        registerUserResponse.setMessage(STR."Registration successful\{user}");
        return registerUserResponse;
    }



    public static Task map(AddTaskRequest addTaskRequest) {
        Task newTask = new Task();
        newTask.setTitle(addTaskRequest.getTitle());
        newTask.setDescription(addTaskRequest.getDescription());
        newTask.setStatus(TaskStatus.CREATED);
        newTask.setPriority(addTaskRequest.getPriority());
        newTask.setDueDate(LocalDate.from(addTaskRequest.getDueDate()));
        return newTask;
    }




    public static UpdateTaskResponse mapEditTaskResponse() {
        UpdateTaskResponse response = new UpdateTaskResponse();
        response.setMessage("Task updated successfully");

        return response;

    }
        public static DeleteTaskResponse mapDeleteTaskResponse() {
            DeleteTaskResponse response = new DeleteTaskResponse();
        response.setMessage("Task updated successfully");
        return response;

    }

    public static Task map(TaskUpdateRequest taskUpdateRequest, Task task) {
        task.setTitle(taskUpdateRequest.getTitle().toLowerCase());
        task.setDescription(taskUpdateRequest.getDescription().toLowerCase());
        task.setStatus(TaskStatus.PENDING);
        task.setPriority(taskUpdateRequest.getPriority());
        task.setDueDate(LocalDate.from(taskUpdateRequest.getDueDate()));
        return task;
    }


    public static ShareTaskResponse getShareTaskResponse() {
        ShareTaskResponse shareTaskResponse = new ShareTaskResponse();
        shareTaskResponse.setMessage("Task shared successfully");
        return shareTaskResponse;
    }

}
