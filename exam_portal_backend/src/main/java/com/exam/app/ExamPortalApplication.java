package com.exam.app;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.exam.app.model.Role;
import com.exam.app.model.User;
import com.exam.app.model.UserRole;
import com.exam.app.service.UserService;

@SpringBootApplication
public class ExamPortalApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(ExamPortalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("starting code");
		
//		User user = new User();
//		
//		user.setUsername("a");
//		user.setFirstName("b");
//		user.setLastName("v");
//		user.setPassword("abc");
//		user.setEmail("masum@gmail.com");
//		user.setProfile("default.png");
//		
//		Role role1 = new Role();
//		role1.setRoleId(44L);
//		role1.setRoleName("Admin");
//		
//		Set<UserRole> userRoleSet = new HashSet<>();
//		UserRole userRole = new UserRole();
//		userRole.setRole(role1);
//		userRole.setUser(user);
//		
//		userRoleSet.add(userRole);
//		
//		User user1 = this.userService.createUser(user, userRoleSet);
//		
//		System.out.println(user1.getUsername());
		
	}

	
}
