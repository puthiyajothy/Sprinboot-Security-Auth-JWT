package com.sgic.internal.employee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.internal.employee.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	
	User findByusername(String username);
}
