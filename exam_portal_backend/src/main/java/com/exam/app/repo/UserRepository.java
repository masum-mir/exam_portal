package com.exam.app.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.exam.app.model.User;

public interface UserRepository extends JpaRepositoryImplementation<User, Long> {

	public User findByUsername(String user);
	
}
