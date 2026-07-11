package com.springbootTSM.task_management_system.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.springbootTSM.task_management_system.dto.request.TaskRequestDto;
import com.springbootTSM.task_management_system.dto.request.UpdateTaskRequestDto;
import com.springbootTSM.task_management_system.dto.response.TaskResponseDto;
import com.springbootTSM.task_management_system.entity.Task;

public interface TaskService {

    Task createTask(TaskRequestDto dto);
    Task findById(Integer id);
    List<Task> findAllTask();
    Task updateTask(Integer id, UpdateTaskRequestDto dto);
    void deleteTask(Integer id);
    Page<TaskResponseDto> getAllTask(int page, Integer size);
    Task startTask(Integer id);
    Task completeTask(Integer id);
    
    
}
