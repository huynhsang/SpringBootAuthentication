package com.sanghuynh.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.sanghuynh.demo.entity.User;



@Transactional
public interface UserDAO extends JpaRepository<User, Integer>{

	User findByUsername(String username);
	
}
