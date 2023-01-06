package com.exam.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.exam.app.config.JwtUtils;
import com.exam.app.model.JwtRequest;
import com.exam.app.model.JwtResponse;
import com.exam.app.service.impl.UserDetailsServiceImplement;


@RestController
@CrossOrigin("*")
public class AuthenticateController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsServiceImplement userDetailsServiceImplement;

	@Autowired
	private JwtUtils jwtUtils;
	
	// generated token 
	@PostMapping("/generate-token")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
		
		try {
			
			authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
			
		} catch(UsernameNotFoundException e) {
			e.printStackTrace();
			throw new Exception("User not found");
		} catch(Exception e) {
			e.printStackTrace();
		}
// authenticate
		
		UserDetails userDetails = this.userDetailsServiceImplement.loadUserByUsername(jwtRequest.getUsername());
		String token = this.jwtUtils.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse(token));
		
	}
	
	private void authenticate(String username, String passord) throws Exception {
		
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, passord));
		}catch(DisabledException e) {
			throw new Exception("USER DISABLED " + e.getMessage());
		} catch(BadCredentialsException e) {
			throw new Exception("Invalid Credentials "+ e.getMessage());
		}
		
	
	}
	
	
}
