package com.springbootTSM.task_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootTSM.task_management_system.entity.Task;

public interface TaskRepository extends JpaRepository<Task , Integer>{
	

}
