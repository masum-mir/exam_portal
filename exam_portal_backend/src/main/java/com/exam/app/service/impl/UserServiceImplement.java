package com.exam.app.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.app.model.User;
import com.exam.app.model.UserRole;
import com.exam.app.repo.RoleRepository;
import com.exam.app.repo.UserRepository;
import com.exam.app.service.UserService;

@Service
public class UserServiceImplement implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	
	// creating user 
	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception  {
		
		User local = this.userRepository.findByUsername(user.getUsername());
		
		if(local!=null) {
			System.out.println("User is already there !!");
			throw new Exception("User already present !!");
		} else {
			for(UserRole ur: userRoles) {
				this.roleRepository.save(ur.getRole());
			}
			
			user.getUserRoles().addAll(userRoles);
			local = this.userRepository.save(user);
			
		}
		
		return local;
	}

// getting user by username
	@Override
	public User getUser(String username) {
		
		return this.userRepository.findByUsername(username);
	}

	@Override
	public void deleteUser(Long userId) {
		this.userRepository.deleteById(userId);
		
	}

}
