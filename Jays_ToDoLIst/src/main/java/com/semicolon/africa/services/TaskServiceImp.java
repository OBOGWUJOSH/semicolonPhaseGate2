package com.semicolon.africa.services;


import com.semicolon.africa.data.models.Task;
import com.semicolon.africa.data.models.User;
import com.semicolon.africa.data.repositories.TaskRepository;
import com.semicolon.africa.data.repositories.UserRepository;
import com.semicolon.africa.dtos.request.*;
import com.semicolon.africa.dtos.response.AddTaskResponse;
import com.semicolon.africa.dtos.response.DeleteTaskResponse;
import com.semicolon.africa.dtos.response.UpdateTaskResponse;
import com.semicolon.africa.utilities.TodoAppException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.semicolon.africa.utilities.Mapper.*;
import static com.semicolon.africa.utilities.Validators.*;
import static java.time.LocalDateTime.now;


@Service
@AllArgsConstructor
public class TaskServiceImp implements TaskService {

    private final TaskRepository taskRepository;

    private final UserRepository userRepository;


    public AddTaskResponse addTask(AddTaskRequest addTaskRequest) {
        Task task = new Task();
        task.setDescription(addTaskRequest.getDescription());
        task.setTitle(addTaskRequest.getTitle());
        task.setPriority(addTaskRequest.getPriority());
        task.setStatus(addTaskRequest.getTaskStatus());
//        addTaskValidation(addTaskRequest);
        task= taskRepository.save(task);
//        sendTaskEmail(savedTask.getEmail(), "Your task have been added successfully");
        return mapAddTaskResponse(task);
    }

//    private void sendTaskEmail(String email,String message) {
//        JavaMailRequest javaMailRequest = new JavaMailRequest();
//        javaMailRequest.setTo(email);
//        javaMailRequest.setMessage(message);
//        javaMailRequest.setSubject("TodoApp Confirmation");
//        javaMailRequest.setFrom(mailConfig.getFromEmail());
//        mailService.send(javaMailRequest);
//    }

    @Override
    public UpdateTaskResponse updateTask(TaskUpdateRequest taskUpdateRequest) {
        updatedTaskValidation(taskUpdateRequest);
        Task updatedTask = updateTaskUserVerification(taskUpdateRequest);
        taskRepository.save(updatedTask);
        return mapEditTaskResponse();
    }

    private Task updateTaskUserVerification(TaskUpdateRequest taskUpdateRequest) {
        Task task = findTaskByTitle(taskUpdateRequest.getTitle());
        task.setTitle(taskUpdateRequest.getNewTitle());
        task.setStatus(task.getStatus());
        task.setDescription(task.getDescription());
        task.setDueDate(task.getDueDate());
        task.setDateTimeUpdated(now());
        return task;
    }

    @Override
    public DeleteTaskResponse deleteTask(DeleteTaskRequest deleteTaskRequest) {
        Task task = findTaskByTitle(deleteTaskRequest.getTitle());
        taskRepository.delete(task);
        return mapDeleteTaskResponse();
    }

    @Override
    public List<Task> viewAllTask() {
         return taskRepository.findAll();
    }

//    @Override
//    public ShareTaskResponse shareTask(ShareTaskRequest shareTaskRequest) {
//        shareTaskValidation(shareTaskRequest);
//        Task task = findTaskByTitle(shareTaskRequest.getTitle());
//        task.setReceiver(shareTaskRequest.getReceiver());
//        taskRepository.save(task);
//        assignTaskToUserConfirmation(shareTaskRequest, task);
//        sendTaskEmail(task.getEmail(), "Your task have been shared successfully");
//
//        return getShareTaskResponse();
//    }


//    private void addTaskUserVerification(AddTaskRequest addTaskRequest, Task savedTask) {
//        User = findByUsername(addTaskRequest.getUsername());
//        List<Task> tasks= user.getTasks();
//        tasks.add(savedTask);
//        user.setTasks(tasks);
//        userRepository.save(user);
//    }
//    private Task updateTaskUserVerification(TaskUpdateRequest taskUpdateRequest) {
//        Task task = findTaskByTitle(taskUpdateRequest.getTitle());
//        if(task==null)throw new TodoAppException("Task not found");
//        if (!task.getUsername().equals(taskUpdateRequest.getUsername()))
//            throw new TodoAppException("Task not found for username");
//        return map(taskUpdateRequest, task);
//    }
    private void assignTaskToUserConfirmation(ShareTaskRequest shareTaskRequest, Task task) {
        User user = findByUsername(shareTaskRequest.getReceiver());
        List<Task> tasks= user.getTasks();
        for (Task t : tasks) {
            if (t.getTitle().equals(task.getTitle())) throw new TodoAppException("Task already exist");}
        tasks.add(task);
        user.setTasks(tasks);
        userRepository.save(user);
    }



    private Task findTaskByTitle(String title) {
         return taskRepository.findTaskByTitle(title)
                 .orElseThrow(()->new TodoAppException("task with not found with tiltle: "+ title));
    }
    @Override
    public Task viewTaskByTitle(ViewTaskByTitleRequest viewTaskByTitleRequest) {
        return findTaskByTitle(viewTaskByTitleRequest.getTitle());
    }

    private User findByUsername(String username){
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new TodoAppException("User not found");
        } else {
            return user;
        }
    }
    private AddTaskResponse mapAddTaskResponse(Task task) {
        AddTaskResponse response = new AddTaskResponse();
        response.setTaskId(task.getId());
        response.setMessage("Task added successfully");
        return response;
    }
}



