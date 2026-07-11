package com.springbootTSM.task_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.springbootTSM.task_management_system.dao.TaskManagementDao;
import com.springbootTSM.task_management_system.dto.request.TaskRequestDto;
import com.springbootTSM.task_management_system.dto.request.UpdateTaskRequestDto;
import com.springbootTSM.task_management_system.dto.response.TaskResponseDto;
import com.springbootTSM.task_management_system.entity.Task;
import com.springbootTSM.task_management_system.enums.TaskStatus;
import com.springbootTSM.task_management_system.exception.InvalidTaskStateException;
import com.springbootTSM.task_management_system.exception.TaskNotFoundException;
import com.springbootTSM.task_management_system.mapper.Mapper;

import jakarta.transaction.Transactional;

@Service
public class TaskServiceImp implements TaskService{

	private TaskManagementDao tmDao;
	
	public TaskServiceImp(TaskManagementDao tmDao) {
		this.tmDao = tmDao;
	}

	@Override
	@Transactional
	public Task createTask(TaskRequestDto dto) {

		Task task=Mapper.dtoToTaskEntity(dto);
		task.setStatus(TaskStatus.PENDING);
		return tmDao.saveDao(task);
	}

	@Override
	public Task findById(Integer id) {
		
		return tmDao.
				findTaskByIdDao(id).
				orElseThrow(()->new TaskNotFoundException(
						"Task not found with id: "+id));
	}

	@Override
	public List<Task> findAllTask() {
		
		return tmDao.findAllTask();
	}
	
	@Override
	public Task updateTask(Integer id, UpdateTaskRequestDto dto) {
	
		Task existingTask=tmDao.findTaskByIdDao(id).
				orElseThrow(()->new TaskNotFoundException(
						"Task not found with id: "+id));
		
		if(dto.getTitle()!=null) {
			existingTask.setTitle(dto.getTitle());
		}
		if(dto.getDescription()!=null) {
			existingTask.setDescription(dto.getDescription());
		}
		if(dto.getTaskpriority()!=null) {
			existingTask.setPriority(dto.getTaskpriority());
		}
		
		return tmDao.saveDao(existingTask);
	}
	
	@Override
	@Transactional
	public void deleteTask(Integer id) {
		
		Task task=tmDao.findTaskByIdDao(id).
		orElseThrow(()->new TaskNotFoundException("No Task is Found with: "+id));
	
		
		tmDao.deleteByIdDao(id);
	
	}

	@Override
	public Page<TaskResponseDto> getAllTask(int page, Integer size) {
		
		int MAX_SIZE=3;
		
		if(size>MAX_SIZE)
			size=MAX_SIZE;
		Sort sort=Sort.by("id").descending();
		
		Pageable pageable=PageRequest.of(page, size,sort);
		Page<Task> taskPage=tmDao.findAllTasks(pageable);
		
		return taskPage.map(Mapper::taskToResponseDto);
	}

	@Override
	public Task startTask(Integer id) {
		
		Task t=tmDao.findTaskByIdDao(id).orElseThrow(
				()->new TaskNotFoundException("Task Not Found with this id: "+id));
		
		if(t.getStatus()!=TaskStatus.PENDING) {
			throw new InvalidTaskStateException("Task cannot be started because current status is: "+t.getStatus());
		}
		t.setStatus(TaskStatus.IN_PROGRESS);
		
		return tmDao.saveDao(t);
	}

	@Override
	public Task completeTask(Integer id) {
		
		Task task=tmDao.findTaskByIdDao(id).orElseThrow(
				()->new TaskNotFoundException("Task not found with this id: "+id));
		
		if(task.getStatus()!=TaskStatus.IN_PROGRESS) {
			throw new InvalidTaskStateException
			("Task cannot be Completed Current Task status is: "+task.getStatus());
		}
		task.setStatus(TaskStatus.COMPLETED);
		
		return tmDao.saveDao(task);
	}
	
}
