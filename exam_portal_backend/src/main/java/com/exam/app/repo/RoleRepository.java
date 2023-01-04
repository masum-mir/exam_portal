package com.exam.app.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.exam.app.model.Role;

public interface RoleRepository extends JpaRepositoryImplementation<Role, Long>{
	
	

}
