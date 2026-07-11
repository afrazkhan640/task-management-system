package com.springbootTSM.task_management_system.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springbootTSM.task_management_system.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByUsername(String username);
}
