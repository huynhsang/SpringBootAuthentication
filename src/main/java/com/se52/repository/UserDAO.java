package com.se52.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.se52.entity.User;

@Transactional
public interface UserDAO extends JpaRepository<User, Integer>{

	User findByUsername(String username);
	
}
