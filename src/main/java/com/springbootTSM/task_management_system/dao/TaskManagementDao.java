package com.springbootTSM.task_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.springbootTSM.task_management_system.entity.Task;
import com.springbootTSM.task_management_system.repository.TaskRepository;

@Repository
public class TaskManagementDao {

	@Autowired
	TaskRepository taskRepository;
	
	public Task saveDao(Task task) {
		
		return taskRepository.save(task);
	}
	

	public Optional<Task> findTaskByIdDao(Integer id) {
		
		return taskRepository.findById(id);
	}
	
	public List<Task> findAllTask(){
		
		return taskRepository.findAll();
	}
	
	public void deleteByIdDao(Integer id) {
		
		taskRepository.deleteById(id);
	}
	
	public Page<Task> findAllTasks(Pageable pageable) {
	    return taskRepository.findAll(pageable);
	}

}
