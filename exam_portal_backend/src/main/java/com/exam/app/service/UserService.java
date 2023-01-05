package com.exam.app.service;

import java.util.Set;

import com.exam.app.model.User;
import com.exam.app.model.UserRole;


public interface UserService {
	
	// create user
	public User createUser(User user, Set<UserRole> userRoles) throws Exception;
	
	//get user by username
	public User getUser(String username);
	
	// delete user by id
	
	public void deleteUser(Long userId);
}
