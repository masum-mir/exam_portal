<<<<<<< HEAD:exam_portal_backend/src/main/java/com/exam/model/UserRole.java
package com.exam.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
=======
package com.exam.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
>>>>>>> 05f8e26378f826fee8dbb018ce7835976012d8c1:exam_portal_backend/src/main/java/com/exam/app/model/UserRole.java

@Entity
public class UserRole {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userRoleId;
	
<<<<<<< HEAD:exam_portal_backend/src/main/java/com/exam/model/UserRole.java
=======
	// user
	@ManyToOne(fetch = FetchType.EAGER)
	private User user;
	
	@ManyToOne
	private Role role;

	
	public UserRole() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Long userRoleId) {
		this.userRoleId = userRoleId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	
	
	
>>>>>>> 05f8e26378f826fee8dbb018ce7835976012d8c1:exam_portal_backend/src/main/java/com/exam/app/model/UserRole.java
}
