package com.mb.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mb.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUserName(String userName);
	
	User findByUserNameOrEmail(String userName, String email);

}
