package com.exam.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.exam.app.service.impl.UserDetailsServiceImplement;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MySecurityConfig {
	
	@Autowired
	private UserDetailsServiceImplement userDetailsServiceImplement;
	
	@Autowired
	private JwtAuthenticationEntryPoint unauthorizedHandler;
	
	@Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter;
	
//	@Bean
//	public BCryptPasswordEncoder passwordEncoder() {
//		return null;
//		
//	}
//	
	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(this.userDetailsServiceImplement).passwordEncoder(passwordEncoder());
//	}
//	
	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http
//			.csrf()
//			.disable()
//			.cors()
//			.disable()
//			.authorizeRequests()
//			.antMatchers("/generate-token","/user/").permitAll()
//			.antMatchers(HttpMethod.OPTIONS).permitAll()
//			.anyRequest().authenticated()
//			.and()
//			.exceptionHandling().authenticationEntryPoint(unauthorizedHandler)
//			.and()
//			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//		
//		http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
//	}
//	
	 @Bean
	  public DaoAuthenticationProvider authenticationProvider() {
	      DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	       
	      authProvider.setUserDetailsService(this.userDetailsServiceImplement);
	      authProvider.setPasswordEncoder(passwordEncoder());
	   
	      return authProvider;
	  }
	
	 @Bean
	  public PasswordEncoder passwordEncoder() {
//	    return new BCryptPasswordEncoder();
		 return NoOpPasswordEncoder.getInstance();
	  }
	 
	 @Bean
	  public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
	    return authConfig.getAuthenticationManager();
	  }
//	 @Override
//	 @Bean
//	 public AuthenticationManager authenticationManagerBean() throws Exception {
//		 return super.authenticationManagerBean();
//	 }
	
//	@SuppressWarnings("deprecation")
	@Bean
	  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
		.csrf()
		.disable()
		.cors()
		.disable().httpBasic()
	    .and()
		.authorizeRequests()
		.requestMatchers("/generate-token", "/user/").permitAll()
		.requestMatchers(HttpMethod.OPTIONS).permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.exceptionHandling()
		.authenticationEntryPoint(unauthorizedHandler)
		.and()
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	    	
	    
	    http.authenticationProvider(authenticationProvider());

	    http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
	    
	    return http.build();
	  }

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//            .authorizeHttpRequests((authz) -> authz
//                .anyRequest().authenticated()
//            )
//            .httpBasic();
//        return http.build();
//    }
	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		super.configure(auth);
//
//	}	
    
//    public DaoAuthenticationProvider daoAuthenticationProvider() {
//    	DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//    	provider.setUserDetailsService(this.custom);a
//    }
//    
//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return (web) -> web.ignoring().antMatchers("/ignore1", "/ignore2");
//    }
//    
//    @Bean
//    public AuthenticationManager authenticationManagerBean(AuthenticationConfiguration configuration) throws Exception {
//    	return configuration.getAuthenticationManager();
//    }

}
