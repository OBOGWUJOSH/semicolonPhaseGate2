package com.semicolon.africa.services;


import com.semicolon.africa.data.models.Task;
import com.semicolon.africa.dtos.request.*;
import com.semicolon.africa.dtos.response.AddTaskResponse;
import com.semicolon.africa.dtos.response.DeleteTaskResponse;
import com.semicolon.africa.dtos.response.UpdateTaskResponse;

import java.util.List;

public interface TaskService {

 AddTaskResponse addTask(AddTaskRequest addTaskRequest);

 DeleteTaskResponse deleteTask(DeleteTaskRequest deleteTaskRequest);

 Task viewTaskByTitle(ViewTaskByTitleRequest viewTaskByTitleRequest);

 List<Task> viewAllTask();


 UpdateTaskResponse updateTask(TaskUpdateRequest taskUpdateRequest);


}


